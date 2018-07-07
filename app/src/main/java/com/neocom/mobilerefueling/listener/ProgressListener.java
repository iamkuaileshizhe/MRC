package com.neocom.mobilerefueling.listener;

/**
 * Created by admin on 2017/10/25.
 */

public interface ProgressListener {
    void update(long bytesRead, long contentLength, boolean done);
}
