package ks.common.model.message;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Represents an order/report sent between a General (User) and Unit/Force
 */
public class UnitMessage {
    // Unique ID for this order
    protected String id;

    // Message type (order or report)
    protected UnitMessageType type = UnitMessageType.ORDER;

    // Message status (pending, en_route, delivered)
    protected UnitMessageStatus status = UnitMessageStatus.PENDING;

    // User that sent the order
    protected String userId;

    // destination Unit/Force
    // If the type == REPORT, then this is the source of the message and the userId is the destination
    protected String recipientId;

    // Optional message subject
    protected String subject;

    // Content message of this order
    protected String content;

    // Time when this order was created/sent
    protected ZonedDateTime createdTimestamp = ZonedDateTime.now();

    // Time when this order was received by the destination unit/force
    protected ZonedDateTime deliveryTimestamp;

    // IDs of other UnitMessages that are related to this message
    // Normally, there would be only one: an Order would be linked to a Report and vice-versa.
    // It's possible that a single Order may have multiple Reports, or that a many Orders are satisfied with a single Report
    protected Set<String> linkedMessages = new HashSet<>();

    public UnitMessage(){}

    public UnitMessage(UnitMessageType type, String userId, String recipientId, String subject, String content){
        this.id = "" + UUID.randomUUID();
        this.type = type;
        this.userId = userId;
        this.recipientId = recipientId;
        this.subject = subject;
        this.content = content;
        this.createdTimestamp = ZonedDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(UnitMessageType type) {
        this.type = type;
    }

    public UnitMessageType getType() {
        return type;
    }

    public void setStatus(UnitMessageStatus status) {
        this.status = status;
    }

    public void setDelivered(){
        setStatus(UnitMessageStatus.DELIVERED);
        setDeliveryTimestamp(ZonedDateTime.now());
    }

    public UnitMessageStatus getStatus() {
        return status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
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

    public ZonedDateTime getDeliveryTimestamp() {
        return deliveryTimestamp;
    }

    public void setDeliveryTimestamp(ZonedDateTime deliveryTimestamp) {
        this.deliveryTimestamp = deliveryTimestamp;
    }

    public Set<String> getLinkedMessages() {
        return linkedMessages;
    }
}
