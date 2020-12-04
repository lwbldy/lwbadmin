package com.pearadmin.common.plugins.system.service.ipml;

import com.pearadmin.common.plugins.system.service.SystemInfoService;
import com.pearadmin.common.plugins.system.vo.SystemInfo;
import org.springframework.stereotype.Service;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("systemInfoService")
public class SystemInfoServiceImpl implements SystemInfoService {
    @Override
    public SystemInfo getSystemInfo() {

        SystemInfo systemInfo = new SystemInfo();

        oshi.SystemInfo si = new oshi.SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();
        systemInfo.setOs(os.toString());

        //获取内存
        GlobalMemory memory = hal.getMemory();
        systemInfo.setMemoryTotal(memory.getTotal());
        systemInfo.setMemoryAvailable(memory.getAvailable());

        //获取运行时间
        CentralProcessor processor = hal.getProcessor();
        systemInfo.setRunTime(FormatUtil.formatElapsedSecs(processor.getSystemUptime()));

        //获取cpu使用率
        systemInfo.setCpuLoadTicks(processor.getSystemCpuLoadBetweenTicks());

        //cpu温度
        Sensors sensors = hal.getSensors();
        systemInfo.setCpuTemperature(sensors.getCpuTemperature());

        //盘符信息
        List<Map<String,Object>> fileSystemList = new ArrayList<Map<String,Object>>();

        FileSystem fileSystem = os.getFileSystem();
        OSFileStore[] fsArray = fileSystem.getFileStores();

        for (OSFileStore fs : fsArray) {
            long usable = fs.getUsableSpace();
            long total = fs.getTotalSpace();

            Map<String,Object> map = new HashMap<String,Object>();
            map.put("name",fs.getMount());// 盘符名称
            map.put("usableStr",FormatUtil.formatBytes(usable));
            map.put("usable",usable);

            map.put("totalStr",FormatUtil.formatBytes(total));
            map.put("total",total);
        }
        systemInfo.setFileStore(fileSystemList);
        return systemInfo;
    }
}
