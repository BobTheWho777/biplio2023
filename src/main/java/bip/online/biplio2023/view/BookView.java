package bip.online.biplio2023.view;

import bip.online.biplio2023.entity.BookEntity;
import bip.online.biplio2023.response.ListResponse;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

@Route("books")
public class BookView extends VerticalLayout {

    private final RestTemplate restTemplate = new RestTemplate();
    private final Grid<BookEntity> grid = new Grid<>(BookEntity.class);

    public BookView() {
        grid.setColumns("id", "title", "author", "publisher", "genre", "year");
        grid.setSizeFull();

        Button refreshButton = new Button("Обновить", event -> refreshData());

        add(refreshButton, grid);
        setSizeFull();

        refreshData();
    }

    private void refreshData() {
        ListResponse response = restTemplate.getForObject(
                "http://localhost:8080/api/v1/book/all", ListResponse.class);
        if (response != null && response.isSuccess()) {
            grid.setItems(response.getData());
        }
    }
}
