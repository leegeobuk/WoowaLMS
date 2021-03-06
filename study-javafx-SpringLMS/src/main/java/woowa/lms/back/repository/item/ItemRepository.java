package woowa.lms.back.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.domain.item.Item;
import woowa.lms.back.search.SearchCriteria;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long>, CustomItemRepository {

    @Query("SELECT i FROM Item i WHERE type(i) = Book AND id = :id")
    Optional<Book> findBookById(@Param(value = "id") Long id);
}
