package utils;
import  java.util.*;
import java.io.*;
import models.*;
public class FileManager{
    private String usersfilepath="src/files/users.txt";
    private String booksfilepath="src/files/books.txt";
    private String transactionsfilepath="src/files/transactions.txt";
    private String Reservationfilepath="src/files/Reservation.txt";
    public ArrayList<User>ReadUsers(){
        File f=new File(usersfilepath);
        ArrayList<User> u=new ArrayList<>();
        try{
            Scanner r=new Scanner(f);
            while(r.hasNext()){
                String line=r.nextLine().trim();
                String[]parts=line.split("\\s+");
                User user=new User(Long.parseLong(parts[0]),parts[1],parts[2],
                        parts[3],parts[4],parts[5]);
                u.add(user);
            }
            r.close();
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
        return u;
    }
    public void WriteUsers(ArrayList<User>users){
        File f=new File(usersfilepath);
        try{
            PrintWriter p=new PrintWriter(f);
            for(int i=0;i<users.size();i++){
                User user=users.get(i);
                p.println(user.getId()+" "+user.getUsername()+" "+user.getPassword()+" "
                        +user.getPhone()+" "+user.getEmail()+" "+user.getRole());
            }
            p.close();
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }
    public ArrayList<Book> ReadBooks(){
        File f=new File(booksfilepath);
        ArrayList<Book> b=new ArrayList<>();
        try{
            Scanner r=new Scanner(f);
            while(r.hasNext()){
                String line=r.nextLine().trim();
                String[]parts=line.split("\\s+");
                Book book=new Book(Long.parseLong(parts[0]),parts[1],parts[2],parts[3]
                        ,Integer.parseInt(parts[4]),Integer.parseInt(parts[5]));
                b.add(book);
            }
            r.close();
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
        return b;
    }
    public void WriteBooks(ArrayList<Book>books){
        File f=new File(booksfilepath);
        try{
            PrintWriter p=new PrintWriter(f);
            for(int i=0;i<books.size();i++){
                Book b=books.get(i);
                p.println(b.getId()+" "+b.getTitle()+" "+b.getAuthor()+" "
                        +b.getGenre()+" "+b.getPublicationYear()+" "+b.getAmount());
            }
            p.close();
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }
    public ArrayList<Transaction>ReadTransactions(){
        File f=new File(transactionsfilepath);
        ArrayList<Transaction> T=new ArrayList<>();
        try{
            Scanner r=new Scanner(f);
            while(r.hasNext()){
                String line=r.nextLine().trim();
                String[]parts=line.split("\\s+");
                Transaction action=new Transaction(Long.parseLong(parts[0]),Long.parseLong(parts[1]),
                        Long.parseLong(parts[2]),Long.parseLong(parts[3]),parts[4]);
                T.add(action);
            }
            r.close();
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
        return T;
    }
    public void WriteTransaction(ArrayList<Transaction>transactions){
         File f=new File(transactionsfilepath);
        try{
            PrintWriter p=new PrintWriter(f);
            for(int i=0;i<transactions.size();i++){
                Transaction t=transactions.get(i);
                p.println(t.getId()+" "+t.getPatronId()+" "+t.getLibrarianId() +" "
                        +t.getBookId()+" "+t.getType());
            }
            p.close();
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }
    public ArrayList<Reservation>ReadReservations(){
        File f=new File(Reservationfilepath);
        ArrayList<Reservation> R=new ArrayList<>();
        try{
            Scanner r=new Scanner(f);
            while(r.hasNext()){
                String line=r.nextLine().trim();
                String[]parts=line.split("\\s+");
                Reservation reserve=new Reservation(Long.parseLong(parts[0])
                        , Long.parseLong(parts[1]), Long.parseLong(parts[2]));
                R.add(reserve);
            }
            r.close();
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
        return R;
    }
    public void WriteReservation(ArrayList<Reservation>reservations){
          File f=new File(Reservationfilepath);
        try{
            PrintWriter p=new PrintWriter(f);
            for(int i=0;i<reservations.size();i++){
                Reservation r=reservations.get(i);
                p.println(r.getId()+" "+r.getPatronId()+" "+r.getBookId());
            }
            p.close();
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }
}