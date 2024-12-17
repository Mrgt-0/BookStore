package com.example.myapplication.Repository;

import com.example.myapplication.Dao.GenericDaoImpl;
import com.example.myapplication.Model.Book;
import com.example.myapplication.Model.Request;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class RequestRepository extends GenericDaoImpl<Request, Integer> {
    private BookRepository bookRepository;
    private static final Logger logger = LoggerFactory.getLogger(RequestRepository.class);

    public RequestRepository(){
        super(Request.class);
    }

    @Transactional
    public void delete(int requestId) {
        Request request = entityManager.find(Request.class, requestId);
        if (request != null) {
            entityManager.remove(request);
            logger.info("Запрос с ID {} успешно удален.", requestId);
        } else {
            logger.warn("Не удалось удалить запрос: запрос с ID {} не найден.", requestId);
            throw new IllegalArgumentException("Запрос не найден с ID: " + requestId);
        }
    }

    @Override
    protected String getCreateSql(){
        return "INSERT INTO Request(bookId) VALUES (?)";
    }

    @Override
    protected void populateCreateStatement(PreparedStatement statement, Request request) throws SQLException{
        statement.setInt(1, request.getBook().getBookId());
        logger.info("Заполняем запрос на создание запроса для книги с ID: {}", request.getBook().getBookId());
    }

    @Override
    protected void setId(Request request, Integer id){
        request.setRequestId(id);
    }

    @Override
    protected String getSelectByIdSql(){
        return "SELECT * FROM Request WHERE requestId = ?";
    }

    @Override
    protected void setIdParameter(PreparedStatement statement, Integer id) throws SQLException{
        statement.setInt(1, id);
    }

    @Override
    protected Request mapResultSetToEntity(ResultSet resultSet) throws SQLException{
        int bookId = resultSet.getInt("bookId");

        Optional<Book> optionalBook = bookRepository.getById(bookId);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            logger.info("Запрос загружен для книги с ID: {}", bookId);
            return new Request(book);
        } else {
            logger.warn("Книга с ID {} не найдена!", bookId);
            throw new SQLException("Книга не найдена для ID: " + bookId);
        }
    }

    @Override
    protected String getSelectAllSql(){
        return "SELECT * FROM Request";
    }

    @Override
    protected String getUpdateSql(){
        return "UPDATE Request SET requestId = ?";
    }

    @Override
    protected void populateUpdateStatement(PreparedStatement statement, Request request) throws SQLException {
        statement.setInt(1, request.getBook().getBookId());
        statement.setInt(2, request.getRequestId());
        logger.info("Заполняем запрос на обновление запроса с ID: {}", request.getRequestId());
    }

    @Override
    protected String getDeleteSql(){
        return "DELETE FROM Request WHERE requestId = ?";
    }
}
