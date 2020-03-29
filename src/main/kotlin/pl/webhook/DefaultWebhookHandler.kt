package pl.webhook

import org.springframework.stereotype.Component
import pl.entity.Message
import pl.entity.MessengerResponse
import pl.entity.Recipient
import pl.entity.WebhookRequest
import pl.logger

@Component
class DefaultWebhookHandler {
    fun handle(webhookRequest: WebhookRequest): MessengerResponse {
        logger.info("Handling default intent")
        val recipientId: String = WebhookCommonExtractor.extractRecipientId(webhookRequest)
        val messageContent = DEFAULT_MESSAGE
        return MessengerResponse(Recipient(recipientId), Message(messageContent))
    }

    companion object {
        private val logger by logger()
        const val DEFAULT_MESSAGE = "Nie rozumiem"
    }
}
