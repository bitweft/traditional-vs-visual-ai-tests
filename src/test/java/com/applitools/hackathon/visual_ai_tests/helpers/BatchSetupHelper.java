package com.applitools.hackathon.visual_ai_tests.helpers;

import com.applitools.eyes.BatchInfo;

public class BatchSetupHelper {
    private static BatchSetupHelper visualAiSetupHelper;
    private static BatchInfo batch;

    private BatchSetupHelper() {
        String batchInfoName = "Hackathon";
        batch = new BatchInfo(batchInfoName);
    }

    public static BatchSetupHelper getInstance() {
        if (visualAiSetupHelper == null) {
            visualAiSetupHelper = new BatchSetupHelper();
        }
        return visualAiSetupHelper;
    }

    public BatchInfo getBatchInfo() {
        return batch;
    }
}
