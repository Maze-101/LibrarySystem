package models;

import java.util.Map;
import main.LibrarySystem;

public class Librarian extends User {
    private final LibrarySystem librarySystem;
    
    public Librarian(String username, String password, String phone, String email, LibrarySystem librarySystem) {
        super(librarySystem.getUserCount()+1, username, password, phone, email, "Librarian");
        this.librarySystem = librarySystem;
    }

    public Transaction checkoutBook(Long patronId, Long bookId, Map<Long, Book> bookMap) {
        if (bookMap.containsKey(bookId)) {
            Book book = bookMap.get(bookId);
            if (book.isAvailable()) {
                book.decrementAmount();
                return new Transaction(System.currentTimeMillis(), patronId, this.getId(), bookId, "Checkout");
            }
        }
        return null;
    }

    public boolean returnBook(Long patronId, Long bookId, Map<Long, Book> bookMap) {
        if (bookMap.containsKey(bookId)) {
            bookMap.get(bookId).incrementAmount();
            return true;
        }
        return false;
    }

    public Transaction createReservation(Long patronId, Long bookId, Long librarianId) {
        return new Transaction(System.currentTimeMillis(), patronId, librarianId, bookId, "Reservation");
    }

    public void notifyPatron(Long reservationId, Map<Long, Reservation> resMap) {
        if (resMap.containsKey(reservationId)) {
            resMap.get(reservationId).markAsNotified();
        }
    }
}
