package models;

import java.time.LocalDate;

public class Transaction{
    private Long id;
    private Long patronId;
    private Long librarianId;
    private Long bookId;
    private String type;
    private LocalDate date;
    private LocalDate dueDate;

    public Transaction(Long id, Long patronId, Long librarianId, Long bookId, String type) {
        this.id = id;
        this.patronId = patronId;
        this.librarianId = librarianId;
        this.bookId = bookId;
        this.type = type;
        this.date = LocalDate.now();
        this.dueDate = calculateDueDate();
    }

    public LocalDate calculateDueDate() {
        return LocalDate.now().plusWeeks(2);
    }

    public Boolean setType(String type) {
        this.type = type;
        return true;
    }

    public Long getId() { 
        return id; 
    }
    public Long getPatronId() { 
        return patronId; 
    }
    public Long getLibrarianId() { 
        return librarianId; 
    }
    public Long getBookId() { 
        return bookId; 
    }
    public String getType() { 
        return type; 
    }
    public LocalDate getDate() { 
        return date; 
    }
    public LocalDate getDueDate() { 
        return dueDate; 
    }
}
