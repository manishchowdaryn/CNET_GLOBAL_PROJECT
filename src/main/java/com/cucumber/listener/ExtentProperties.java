package com.cucumber.listener;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * An enum which holds the properties to be set for extent reporter
 */
public enum ExtentProperties {
    INSTANCE;
    private String reportPath;
    private String extentXServerUrl;
    private String projectName;
    
 String folderName = Reporter.createFolder();
    
    ExtentProperties() {
        this.reportPath = "ExtentReport" + File.separator + folderName + File.separator
                + "report.html";
        this.projectName = "default";
    }
    
    /**
     * Gets the report path
     * @return The report path
     */
    public String getReportPath() {
        return reportPath;
    }

    /**
     * Sets the report path
     * @param reportPath The report path value
     */
    public void setReportPath(String report) {
        this.reportPath = report;
    }

    /**
     * Gets the ExtentX server URL
     * @return The ExtentX server URL
     */
    public String getExtentXServerUrl() {
        return extentXServerUrl;
    }

    /**
     * Sets the ExtentX server URL
     * @param extentXServerUrl The ExtentX server URL
     */
    public void setExtentXServerUrl(String extentXServerUrl) {
        this.extentXServerUrl = extentXServerUrl;
    }

    /**
     * Gets the project name
     * @return The project name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Gets the project name
     * @param projectName The project name
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
