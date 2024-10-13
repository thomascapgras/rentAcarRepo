package com.project.rentAcar.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * MessagesConfig is a Spring component that loads and provides access to
 * the various message properties used in the application, such as cancellation
 * and confirmation messages.
 */
@Component
public class MessagesConfig {

    @Value("${app.cancellation.message.title}")
    private String cancellationMessageTitle;

    @Value("${app.cancellation.message.text}")
    private String cancellationMessageText;

    @Value("${app.confirmation.message.title}")
    private String confirmationMessageTitle;

    @Value("${app.confirmation.message.text}")
    private String confirmationMessageText;

    /**
     * Gets the title of the cancellation message.
     *
     * @return the cancellation message title
     */
    public String getCancellationMessageTitle() {
        return cancellationMessageTitle;
    }

    /**
     * Gets the text of the cancellation message.
     *
     * @return the cancellation message text
     */
    public String getCancellationMessageText() {
        return this.cancellationMessageText;
    }

    /**
     * Gets the title of the confirmation message.
     *
     * @return the confirmation message title
     */
    public String getConfirmationMessageTitle() {
        return this.confirmationMessageTitle;
    }

    /**
     * Gets the text of the confirmation message.
     *
     * @return the confirmation message text
     */
    public String getConfirmationMessageText() {
        return this.confirmationMessageText;
    }
}
