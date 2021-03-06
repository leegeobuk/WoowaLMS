package woowa.lms.front.behavior.book.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.item.BookTableController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowBookTable implements Behavior {

    private static final ShowBookTable INSTANCE = new ShowBookTable();

    public static ShowBookTable getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        BookTableController.getController().showBookTable();
    }
}
