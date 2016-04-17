package com.marvin.helper;

import org.apache.commons.lang3.math.NumberUtils;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * Created by dakr on 09.03.16.
 */
public enum RestVersion {
    NOT_SUPPORTED,
    CURRENT,
    OLD;

    private static final int OLD_VERSION = 1;
    private static final int CURRENT_VERSION = 2;

    private static final String VERSION = "version";

    public static RestVersion getRestVersion(final HttpHeaders headers){
        if(!headers.getRequestHeader(VERSION).isEmpty()) {
            final String versionHeader = headers.getRequestHeader(VERSION).get(0);
            if(NumberUtils.isParsable(versionHeader)){
                switch (Integer.parseInt(versionHeader)){
                    case OLD_VERSION:
                        return RestVersion.OLD;
                    case CURRENT_VERSION:
                        return RestVersion.CURRENT;
                    default:
                        return RestVersion.NOT_SUPPORTED;
                }
            } else{
                return RestVersion.NOT_SUPPORTED;
            }
        }
        return RestVersion.OLD;
    }
}
