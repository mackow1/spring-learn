package pl.kowalczyk.maciej.spring.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

}

// TODO: 19.12.2023 Analogicznie do NoteController stworzyć AuthorController
// W nowym kontrolerze obsłużyć żądania protokołu http dla adresu url /authors
// Analogicznie do NoteRepository stworzyć AuthorRepository + test jednostkowy + springowy test jednostkowy


// TODO: 02.01.2024 Wygenerować aplikację springboot za pomocą start.spring.io
// Analogicznie dla aplikacji spring-learn utworzyć warstwy oraz testy dla nowo wygenerowanej aplikacji

// TODO: 05.01.2024 Stworzyć formularz html dla AuthorController analogicznie jak ApartmentController
// https://geek.justjoin.it/komunikacja-frontend-www-z-backend-w-javie/

// TODO: 09.01.2024 Dla wybranych modeli stworzyć Entity, repozytoria i testy

// TODO: 09.01.2024 Dokończyć metody CRUD dla apartment i author repository używając findById i deleteById + testy

// TODO: 12.01.2024 Dodać wszystko do git (branch: core-controller itp.)

// TODO: 12.01.2024 Zrobić refactor ApartmentService, wydzielić metodę do nowej class i dodać ModelMapper
// https://medium.com/@robindamisi/model-mapping-entities-to-dto-pojo-and-vise-versa-in-java-spring-boot-with-lombok-for-security-a34774ced8ff
// Spring validation https://spring.io/guides/gs/validating-form-input/

// TODO: 16.01.2024 Wyświetlić liste dla Author, Car. Dodać mappery i testy

// TODO: 26.01.2024 Zamienić na formularze thymeleaf Car i Author

// TODO: 26.01.2024 Dokończyć inne testy z artykułu
// https://spring.io/guides/gs/testing-web/

// TODO: 30.01.2024 Internacjonalizacja stringów za pomocą ResourceBundle w Spring

// TODO: 30.01.2024 Napisać testy jednostkowe MVC dla wszystkich metod CRUD w ApartmentController

// TODO: 06.02.2024 https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc

// TODO: 09.02.2024 Stworzyć własne wyjątki i dodać ich propagację od warstwy repository

// TODO: 09.02.2024 Dodać do każdej metody crud w teście weryfikację że zgłasza wyjątek

// TODO: 09.02.2024 Zrobić obsługę wyjątków w service dla metod z repository dla modelu Apartment

// TODO: 09.02.2024 Wybrać inny model i stworzyć własne wyjątki biznesowe dla globalnej obsługi wyjątków

// TODO: 13.02.2024 Powielić manage-apartment.html dla innego wybranego modelu

// TODO: 20.02.2024 Dodać Bootstrapa za pomocą zależności maven

// TODO: 23.02.2024 Zrealizować Mockito na własnym przykładzie

// TODO: 23.02.2024 Dla wybranego controllera zrobić 3 typy testów

// TODO: 23.02.2024 W UserDetailService użyć UserRepository, które należy stworzyć
// Użyć password passwordEncoder

// TODO: 27.02.2024 Dodać role dla użytkownika, nowa encja (Role), wybrać właściwą relację (ONE to one etc), zmodyfikować UserService aby brał pod uwagę role.
// Zrobić przykład z Authorities tak jak dla roles. Zweryfikować role i użytkowników w testach kontrolerów (Mock z użytkownikami - role, nazwy itp)