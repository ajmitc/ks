package ks.common.model.message;

import java.time.ZonedDateTime;

/**
 * Represents an order/report sent between a General (User) and Unit/Force
 */
public class UnitMessage {
    // Unique ID for this order
    protected String id;

    // User that sent the order
    protected String userId;

    // ID of destination Unit
    protected String destUnitId;

    // ID of destination force
    protected String destForceId;

    // Optional message subject
    protected String subject;

    // Content message of this order
    protected String content;

    // Time when this order was created/sent
    protected ZonedDateTime createdTimestamp;

    // Time when this order was received by the destination unit/force
    protected ZonedDateTime receivedTimestamp;

    public UnitMessage(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDestUnitId() {
        return destUnitId;
    }

    public void setDestUnitId(String destUnitId) {
        this.destUnitId = destUnitId;
    }

    public String getDestForceId() {
        return destForceId;
    }

    public void setDestForceId(String destForceId) {
        this.destForceId = destForceId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ZonedDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(ZonedDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public ZonedDateTime getReceivedTimestamp() {
        return receivedTimestamp;
    }

    public void setReceivedTimestamp(ZonedDateTime receivedTimestamp) {
        this.receivedTimestamp = receivedTimestamp;
    }
}
