/// <reference path="jquery-1.9.1.min.js" />
var posID = null;
(function (factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD
        define(['jquery'], factory);
    } else if (typeof exports === 'object') {
        // CommonJS
        factory(require('jquery'));
    } else {
        // Browser globals
        factory(jQuery, window, document);
    }
}(function ($, window, document, undefined) {


    /*************************策略对象*****************************/

    var RULES = {
        isNonEmpty: function (value, errorMsg, el) {
            //不能为空

            if (!value.length) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        minLength: function (value, length, errorMsg, el) {
            //大于英文字符
            if (value.length < length) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        maxLength: function (value, length, errorMsg, el) {
            //小于英文字符
            if (value.length > length) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        isMobile: function (value, errorMsg, el) {
            //是否为手机号码
            if (!/(^1[3|5|8][0-9]{9}$)/.test(value)) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        isEmail: function (value, errorMsg, el) {
            //是否为邮箱
            if (!/(^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$)/.test(value)) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        between: function (value, range, errorMsg, el) {
            //大于小于
            var min = parseInt(range.split('-')[0]);
            var max = parseInt(range.split('-')[1]);
            if (value.length < min || value.length > max) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        betweenCN: function (value, range, errorMsg, el) {
            //大于小于中文字数
            var min = parseInt(range.split('-')[0]);
            var max = parseInt(range.split('-')[1]);
            if (getStrLength(value) < min || getStrLength(value) > max) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        onlyEn: function (value, errorMsg, el) {
            //纯英文
            if (!/^[A-Za-z]+$/.test(value)) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        onlyZh: function (value, errorMsg, el) {
            //纯中文
            if (!/^[\u4e00-\u9fa5]+$/.test(value)) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        onlyNum: function (value, errorMsg, el) {
            //数字包含小数
            if (!/^[0-9]+([.][0-9]+){0,1}$/.test(value)) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        onlyInt: function (value, errorMsg, el) {
            //整数
            if (!/^[0-9]*$/.test(value)) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        matchPwd: function (value, errorMsg, el) {
            //匹配密码
            var Ids = $(el).attr("data-matchID");

            if (value != $("#" + Ids).val()) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        },
        isChecked: function (value, errorMsg, el) {
            var i = 0;
            var $collection = $(el).find('input:checked');
            if (!$collection.length) {
                if (!$(el).attr("disabled")) {
                    return errorMsg;
                }
            }
        }
    };

    var getStrLength = function (sStr) { // 获取字符长度 （以中文字符长度为基准）
        var aMatch = sStr.match(/[^\x00-\x80]/g),
            strlen = (sStr.length + (!aMatch ? 0 : aMatch.length));
        return strlen = Math.ceil(strlen / 2);
    }

    /*************************Validator类*****************************/

    var setting = {
        type: null,
        onBlur: null,
        onBlurpass: true,
        onFocus: null,
        onChange: null,
        successTip: false,//
        synchro: true,//同步
        selectID: null//指定位置
    };

    var Validator = function () {
        this.cache = [];
    };

    Validator.prototype.add = function (dom, rules) {
        var self = this;
        for (var i = 0, rule; rule = rules[i++];) {
            (function (rule) {
                var strategyAry = rule.strategy.split(':');
                var errorMsg = rule.errorMsg
                self.cache.push(function () {
                    var strategy = strategyAry.shift(); // 前删匹配方式并赋值
                    strategyAry.unshift(dom.value); // 前插value值
                    strategyAry.push(errorMsg); // 后插出错提示
                    strategyAry.push(dom); // 后插dom
                    if (!RULES[strategy]) {
                        $.error('没有' + strategy + '规则，请检查命名或自行定义');
                    }
                    return {
                        errorMsg: RULES[strategy].apply(dom, strategyAry),
                        el: dom
                    };
                });
            }(rule));
        }
    };

    Validator.prototype.start = function () {
        var result;
        for (var i = 0, validatorFunc; validatorFunc = this.cache[i++];) {
            var result = validatorFunc();
            if (setting.successTip) {
                new Validator().showMsg($(result.el), '', 1);
            }
            if (result.errorMsg) {
                return result;
            }

        };
        
        return true;
    };

    Validator.prototype.showMsg = function (target, msg, status, callback) {
        //status
        // 0 : tip
        // 1 : success
        // 2 : error
        var _current = status ? (status > 1 ? 'error' : 'success') : 'tip';
        var $context = target.parent();
        if (setting.selectID) {
            $context = setting.selectID;
        }

        var $msg = $context.find('.valid_message');
        var _other = target.attr('data-type') || '';
        $msg.remove();
        
        $context.removeClass('success tip error').addClass(_current + ' ' + _other).append('<span class="valid_message">' + msg + '</span>');
    };

    var plugin = {
        init: function (options) {
            var $form = this;
            var $body = $('body');
            var $required = $form.find('.required');
            setting = $.extend(setting, options);

            if (setting.type) {
                $.extend(RULES, setting.type);
            }

            var validator = new Validator();

            posID = setting.selectID;
           // console.log(posID);

            $body.on({
                focus: function (event) {

                    var $this = $(this);
                    var _tipMsg = $this.attr('data-tip') || '';
                    var _status = $this.attr('data-status');
                    if (setting.onBlurpass) {
                        if (_status === undefined || !parseInt(_status)) {
                            //validator.showMsg($this, _tipMsg);
                        }
                    }
                    setting.onFocus ? setting.onFocus.call($this, arguments) : '';

                },
                blur: function (event) {

                    var $this = $(this);
                    var dataValid = $this.attr('data-valid');
                    var validLen = dataValid.split('||');
                    var errCollection = $this.attr('data-error');
                    var errMsgAry = errCollection.split("||");
                    var strategyAry, strategy, errMsg;

                    if (setting.onBlurpass) {
                        for (var i = 0; i < validLen.length; i++) {
                            strategyAry = validLen[i].split(':');
                            strategy = strategyAry.shift();
                            strategyAry.unshift(this.value);
                            strategyAry.push(errMsgAry[i]);
                            strategyAry.push(this);
                            errMsg = RULES[strategy].apply(this, strategyAry);
                            if (errMsg) {
                                $this.attr('data-status', 0);
                                validator.showMsg($this, errMsg, 2);
                                break;
                            }
                        };

                        if (!errMsg) {
                            $this.attr('data-status', 1);
                            if (setting.selectID) {
                                setting.successTip ? validator.showMsg($this, '', 1) : setting.selectID.find('.valid_message').remove();
                            }
                            else {
                                setting.successTip ? validator.showMsg($this, '', 1) : $this.parent().removeClass("error").find('.valid_message').remove();
                            }

                        }
                    }
                    setting.onBlur ? setting.onBlur.call($this, arguments) : '';

                }
            }, '.required');

            $('.required').on('blur', function () {
                if (setting.synchro) {
                    var $this = $(this);
                    var dataValid = $this.attr('data-valid');
                    var validLen = dataValid.split('||');
                    var errCollection = $this.attr('data-error');
                    var errMsgAry = errCollection.split("||");
                    var strategyAry, strategy, errMsg;

                    for (var i = 0; i < validLen.length; i++) {
                        strategyAry = validLen[i].split(':');
                        strategy = strategyAry.shift();
                        strategyAry.unshift(this.value);
                        strategyAry.push(errMsgAry[i]);
                        strategyAry.push(this);
                        errMsg = RULES[strategy].apply(this, strategyAry);
                        if (errMsg) {
                            $this.attr('data-status', 0);
                            validator.showMsg($this, errMsg, 2);
                            break;
                        }
                    };

                    if (!errMsg) {
                        $this.attr('data-status', 1);
                        if (setting.selectID) {
                            setting.successTip ? validator.showMsg($this, '', 1) : setting.selectID.removeClass("error").find('.valid_message').remove();
                        }
                        else {
                            setting.successTip ? validator.showMsg($this, '', 1) : $this.parent().removeClass("error").find('.valid_message').remove();
                        }

                    }

                    setting.onChange ? setting.onChange.call($this, arguments) : '';
                }
            });

        },
        submitValidate: function (options) {
            var $form = options || this;
            var $body = $('body');
            var $required = $form.find('.required');
            var validator = new Validator();
            var $target;

            $.each($required, function (index, el) {
                var $el = $(el);
                var dataValid = $el.attr('data-valid');
                var validLen = dataValid.split('||');
                var errCollection = $el.attr('data-error');
                var errMsgAry = errCollection.split("||");
                var ruleAry = [];

                for (var i = 0; i < validLen.length; i++) {
                    ruleAry.push({
                        strategy: validLen[i],
                        errorMsg: errMsgAry[i]
                    });
                };

                validator.add(el, ruleAry);

            });

            var result = validator.start();

            if (result.errorMsg) {
                $target = $(result.el);
                $target.attr('data-status', 0)[0].focus();
                validator.showMsg($target, result.errorMsg, 2);
                return false;
            }


            return true;
        }
    };

    $.fn.validate = function () {
        var method = arguments[0];
        if (plugin[method]) {
            method = plugin[method];
            arguments = Array.prototype.slice.call(arguments, 1);
        } else if (typeof (method) == 'object' || !method) {
            method = plugin.init;
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.validate Plugin');
            return this;
        }
        return method.apply(this, arguments);
    }


}))


function errorcallback(ID,txt) {
    var _current = "error";
    var $context = $(ID).parent();
    
    if (posID) {
        $context = posID;
    }

    var $msg = $context.find('.valid_message');
    $msg.remove();
    $context.removeClass('success tip error').addClass(_current).append('<span class="valid_message">' + txt + '</span>');
}

//

$(function () {
    //模拟单选
    $(document).on("click", ".label-radio", function () {
        $(this).addClass("on").siblings().removeClass("on");
        $(this).siblings().find("input").prop("checked", false);
        $(this).find("input").prop("checked", true)
    });
    $(".label-radio").each(function () {
        if ($(this).find("input").prop("checked")) {
            $(this).addClass("on")
        }
    });
    //
    //模拟多选
    $(document).on("change", ".label-checkbox", function () {

        if ($(this).find("input").prop("checked")) {
            $(this).addClass("on")
            $(this).find("input").prop("checked", true);
        } else {
            $(this).removeClass("on")
            $(this).find("input").prop("checked", false);
        }
    });

    $(".label-checkbox").each(function () {
        if ($(this).find("input").prop("checked")) {
            $(this).addClass("on")
        }
    });
    //

    //--------------模拟下拉
    $(document).on("click", ".select-box dt a", function (e) {
        e.preventDefault();
        e.stopPropagation();


        if ($(this).parents(".disabled").hasClass("disabled")) {
            return false;
        }

        $(".select-body-box,.selectmask").remove();
        var el = $(this).parents(".select-box");
        el.addClass("open");
        var ht = el.find("dd").html(),
            oftop = el.offset().top + el.height(),
            ofleft = el.offset().left,
            ofwidth = el.width()+2;

        if ($(window).width() < 767) {
            $("body").append("<div class='select-body-box'>" + ht + "</div><a href='javascript:;' class='selectmask'></a>");
            oftop = ($(window).height() - $(".select-body-box").height()) / 2;
            $(".select-body-box").css({ top: oftop });
        } else {
            $("body").append("<div class='select-body-box' style='top:" + oftop + "px; left:" + ofleft + "px; width:" + ofwidth + "px;' >" + ht + "</div><a href='javascript:;' class='selectmask'></a>");
        }





    })
    $(document).on("click", ".select-body-box a", function (e) {
        var inde = $(this).index();
        $(this).addClass("on").siblings().removeClass("on");
        var el = $(".select-box.open");
        el.next(".select-hidden").val($(this).attr("data-val"))
        el.find("dt a b").text($(this).text());
        el.find("dd a").eq(inde).addClass("on").siblings().removeClass("on");
        setTimeout(function () {//其他方法判断open的延迟；
            el.removeClass("open");
        }, 1)
        $(".select-body-box,.selectmask").remove();
    })
    $(document).click(function () {
        $(".select-box.open").removeClass("open");
        $(".select-body-box,.selectmask").remove();
    })
    //end
})
