package bip.online.biplio2023.view;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.response.ListResponse;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

@Route("authors") // URL для страницы
public class AuthorView extends VerticalLayout {

    private final RestTemplate restTemplate;
    private final Grid<AuthorEntity> grid = new Grid<>(AuthorEntity.class);

    public AuthorView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        // Настройка сетки
        grid.setColumns("id", "lastname", "name", "surname");
        grid.setSizeFull();

        // Кнопка для обновления данных
        Button refreshButton = new Button("Обновить", event -> refreshData());

        // Добавление компонентов на страницу
        add(refreshButton, grid);
        setSizeFull();

        // Загрузка данных при открытии страницы
        refreshData();
    }

    private void refreshData() {
        try {
            ListResponse<AuthorEntity> response = restTemplate.getForObject(
                    "http://localhost:8080/api/v1/author/all", ListResponse.class);
            if (response != null && response.isSuccess()) {
                grid.setItems(response.getData());
            } else {
                Notification.show("Ошибка при загрузке данных");
            }
        } catch (Exception e) {
            Notification.show("Ошибка: " + e.getMessage());
        }
    }
}