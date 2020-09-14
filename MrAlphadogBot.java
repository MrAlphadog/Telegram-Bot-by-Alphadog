import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MrAlphadogBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
//        System.out.println(update.getMessage().getText());
//        System.out.println(update.getMessage().getFrom().getFirstName());

        String command = update.getMessage().getText();

        SendMessage message = new SendMessage();

        if (command.equals("/name")){
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText(update.getMessage().getFrom().getFirstName());
        }

        if (command.equals("/lastname")){
            System.out.println(update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getLastName());
        }

        message.setChatId(update.getMessage().getChatId());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public String getBotUsername() {
        return "MrAlphadog_Bot";
    }

    public String getBotToken() {
        return "1368841163:AAG8KazbIyplcEdmQXiSzVaeqFGFfMU09yA";
    }
}
