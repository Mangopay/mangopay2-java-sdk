package com.mangopay.entities;

public class RateLimit {

    private int intervalMinutes;
    private int callsMade;
    private int callsRemaining;
    private long resetTimeSeconds;

    public RateLimit() {
    }

    /**
     * Gets the maximum allowed number of calls in this time interval.
     *
     * @return
     */
    public int getAllowedCalls() {
        return callsMade + callsRemaining;
    }

    /**
     * Gets the number of minutes in this time interval.
     *
     * @return
     */
    public int getIntervalMinutes() {
        return intervalMinutes;
    }

    /**
     * Gets the number of API calls already made in this time interval.
     *
     * @return
     */
    public int getCallsMade() {
        return callsMade;
    }

    /**
     * Sets the number of API calls already made in this time interval.
     *
     * @param callsMade Number of calls
     */
    public void setCallsMade(int callsMade) {
        this.callsMade = callsMade;
    }

    /**
     * Gets the number of calls still allowed to be made in this time interval.
     *
     * @return
     */
    public int getCallsRemaining() {
        return callsRemaining;
    }

    /**
     * Sets the remaining allowed number of calls in this time interval.
     *
     * @param callsRemaining The remaining number of calls allowed
     */
    public void setCallsRemaining(int callsRemaining) {
        this.callsRemaining = callsRemaining;
    }

    /**
     * Gets the time in seconds when the number of allowed calls in this time interval will be reset.
     *
     * @return
     */
    public long getResetTimeSeconds() {
        return resetTimeSeconds;
    }

    /**
     * Sets the time at which the number of allowed calls in this interval will be reset.
     *
     * @param resetTimeSeconds The reset time in seconds
     */
    public void setResetTimeSeconds(long resetTimeSeconds) {
        this.resetTimeSeconds = resetTimeSeconds;
    }

    public RateLimit setIntervalMinutes(int intervalMinutes) {
        this.intervalMinutes = intervalMinutes;
        return this;
    }
}
