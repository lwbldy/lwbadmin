package com.pearadmin.common.plugins.system.vo;

import java.util.List;
import java.util.Map;

public class SystemInfo {
    private String os;
    private String runTime; //运行时间
    private long memoryTotal;//内存总数
    private long memoryAvailable; //可用内存
    private double cpuLoadTicks; //cpu 使用率
    private double cpuTemperature; //cpu 温度
    private List<Map<String,Object>> fileStore; //文件系统

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public long getMemoryTotal() {
        return memoryTotal;
    }

    public void setMemoryTotal(long memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    public long getMemoryAvailable() {
        return memoryAvailable;
    }

    public void setMemoryAvailable(long memoryAvailable) {
        this.memoryAvailable = memoryAvailable;
    }

    public double getCpuLoadTicks() {
        return cpuLoadTicks;
    }

    public void setCpuLoadTicks(double cpuLoadTicks) {
        this.cpuLoadTicks = cpuLoadTicks;
    }

    public double getCpuTemperature() {
        return cpuTemperature;
    }

    public void setCpuTemperature(double cpuTemperature) {
        this.cpuTemperature = cpuTemperature;
    }

    public List<Map<String, Object>> getFileStore() {
        return fileStore;
    }

    public void setFileStore(List<Map<String, Object>> fileStore) {
        this.fileStore = fileStore;
    }
}
