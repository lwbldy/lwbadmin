package com.pearadmin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;

import java.lang.management.MonitorInfo;
import java.util.Arrays;

public class MySystemInfo {
    public static void main(String[] args){
//        Logger LOG = LoggerFactory.getLogger(SystemInfoTest.class);

        SystemInfo si = new SystemInfo();

        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();

        System.out.println("操作系统："+os);

        CentralProcessor processor = hal.getProcessor();
        System.out.println("cpu:"+processor);

        GlobalMemory memory = hal.getMemory();

        System.out.println("内存可用/总共: " + FormatUtil.formatBytes(memory.getAvailable()) + "/"
                + FormatUtil.formatBytes(memory.getTotal()));


        System.out.println("运行时间: " + FormatUtil.formatElapsedSecs(processor.getSystemUptime()));

//
//        System.out.println(
//                "Context Switches/Interrupts: " + processor.getContextSwitches() + " / " + processor.getInterrupts());

//        long[] prevTicks = processor.getSystemCpuLoadTicks();
//        System.out.println("CPU, IOWait, and IRQ ticks @ 0 sec:" + Arrays.toString(prevTicks));
        // Wait a second...
//        Util.sleep(1000);
//        long[] ticks = processor.getSystemCpuLoadTicks();
//        System.out.println("CPU, IOWait, and IRQ ticks @ 1 sec:" + Arrays.toString(ticks));
//        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
//        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
//        long sys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
//        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
//        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
//        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
//        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
//        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
//        long  = user + nice + sys + idle + iowait + irq + softirq + steal;

//        System.out.format(
//                "User: %.1f%% Nice: %.1f%% System: %.1f%% Idle: %.1f%% IOwait: %.1f%% IRQ: %.1f%% SoftIRQ: %.1f%% Steal: %.1f%%%n",
//                100d * user / totalCpu, 100d * nice / totalCpu, 100d * sys / totalCpu, 100d * idle / totalCpu,
//                100d * iowait / totalCpu, 100d * irq / totalCpu, 100d * softirq / totalCpu, 100d * steal / totalCpu);



        System.out.format("CPU 使用率: %.1f%% (counting ticks)%n", processor.getSystemCpuLoadBetweenTicks() * 100);
//        System.out.format("CPU load: %.1f%% (OS MXBean)%n", processor.getSystemCpuLoad() * 100);


//        double[] loadAverage = processor.getSystemLoadAverage(3);
//        System.out.println("CPU load averages:" + (loadAverage[0] < 0 ? " N/A" : String.format(" %.2f", loadAverage[0]))
//                + (loadAverage[1] < 0 ? " N/A" : String.format(" %.2f", loadAverage[1]))
//                + (loadAverage[2] < 0 ? " N/A" : String.format(" %.2f", loadAverage[2])));
        // per core CPU
//        StringBuilder procCpu = new StringBuilder("CPU load per processor:");
//        double[] load = processor.getProcessorCpuLoadBetweenTicks();
//        for (double avg : load) {
//            procCpu.append(String.format(" %.1f%%", avg * 100));
//        }
//        System.out.println(procCpu.toString());
        Sensors sensors = hal.getSensors();
        System.out.format("CPU 温度: %.1f°C%n", sensors.getCpuTemperature());

        // 磁盘
//        System.out.println("Disks:");
//        HWDiskStore[] diskStores = hal.getDiskStores();
//        for (HWDiskStore disk : diskStores) {
//            boolean readwrite = disk.getReads() > 0 || disk.getWrites() > 0;
//
//            System.out.format(" %s: (model: %s - S/N: %s) size: %s, reads: %s (%s), writes: %s (%s), xfer: %s ms%n",
//                    disk.getName(), disk.getModel(), disk.getSerial(),
//                    disk.getSize() > 0 ? FormatUtil.formatBytesDecimal(disk.getSize()) : "?",
//                    readwrite ? disk.getReads() : "?", readwrite ? FormatUtil.formatBytes(disk.getReadBytes()) : "?",
//                    readwrite ? disk.getWrites() : "?", readwrite ? FormatUtil.formatBytes(disk.getWriteBytes()) : "?",
//                    readwrite ? disk.getTransferTime() : "?");
//
//        }

        System.out.println("文件系统:");
        FileSystem fileSystem = os.getFileSystem();
        OSFileStore[] fsArray = fileSystem.getFileStores();
        for (OSFileStore fs : fsArray) {
            long usable = fs.getUsableSpace();
            long total = fs.getTotalSpace();

            System.out.printf("%s 容量：%s,可用：%s \n",fs.getMount(),FormatUtil.formatBytes(usable),FormatUtil.formatBytes(fs.getTotalSpace()));



//            System.out.format(
//                    " %s (%s) [%s] %s of %s free (%.1f%%) is %s "
//                            + (fs.getLogicalVolume() != null && fs.getLogicalVolume().length() > 0 ? "[%s]" : "%s")
//                            + " and is mounted at %s%n",
//                    fs.getName(), fs.getDescription().isEmpty() ? "file system" : fs.getDescription(), fs.getType(),
//                    FormatUtil.formatBytes(usable), FormatUtil.formatBytes(fs.getTotalSpace()), 100d * usable / total,
//                    fs.getVolume(), fs.getLogicalVolume(), fs.getMount());
        }

    }

}
