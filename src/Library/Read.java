package Library;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.*;

public class Read {// read from file

    String line ="";
    private static Read r = null;

    private Read(){}

    public static Read getInstance(){
        if(r ==null){
            r = new Read();
        }
        return r;
    }


    public List<Author> readAuthors(){
        List<Author> auth=new ArrayList<>();
        String path = "D:\\LABORATOARE EAP\\Library\\authors.csv";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line=br.readLine())!=null){
                String[] values = line.split(",");
                Author a = new Author(values[0], values[1], valueOf(values[2]), valueOf(values[3]));
                auth.add(a);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return auth;
    }

    public List<Client> readClients(){
        String path = "D:\\LABORATOARE EAP\\Library\\Clients.csv";
        List<Client> clients=new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line=br.readLine())!=null){
                String[] values = line.split(",");
                Client c = new Client(values[0], values[1], values[2]);
                clients.add(c);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return clients;
    }

    public List<Employee> readEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees=readLibrarian(employees);
        employees= readRegistrator(employees);
        return employees;

    }
    public List<Employee> readLibrarian(List<Employee> employees){
        String path = "D:\\LABORATOARE EAP\\Library\\Librarians.csv";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line=br.readLine())!=null){
                String[] values = line.split(",");
                Employee e = new Librarian(values[0], values[1], values[2], BigDecimal.valueOf(valueOf(values[3])));
                employees.add(e);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return employees;
    }

    public List<Librarian> readLibrarianForBD(List<Librarian> librarians){
        String path = "D:\\LABORATOARE EAP\\Library\\Librarians.csv";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line=br.readLine())!=null){
                String[] values = line.split(",");
                Librarian e = new Librarian(values[0], values[1], values[2], BigDecimal.valueOf(valueOf(values[3])));
                librarians.add(e);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return librarians;
    }

    public List<Registrator> readRegistratorForBD(List<Registrator> registrators){
        String path = "D:\\LABORATOARE EAP\\Library\\Registrators.csv";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line=br.readLine())!=null){
                String[] values = line.split(",");
                Registrator e = new Registrator(values[0], values[1], values[2], BigDecimal.valueOf(valueOf(values[3])));
                registrators.add(e);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return registrators;
    }
    public List<Employee> readRegistrator(List<Employee> employees){
        String path = "D:\\LABORATOARE EAP\\Library\\Registrators.csv";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line=br.readLine())!=null){
                String[] values = line.split(",");
                Employee e = new Registrator(values[0], values[1], values[2], BigDecimal.valueOf(valueOf(values[3])));
                employees.add(e);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return employees;
    }


    public List<Book> readBooks(List<Author> authors, List<Employee> e){
        String path = "D:\\LABORATOARE EAP\\Library\\books.csv";
        List<Book> books=new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line=br.readLine())!=null){
                String[] values = line.split(",");

                Employee employee = new Registrator();
                Registrator r= new Registrator();
                employee = employee.SearchByDesk(e, valueOf(values[6]));
                int index1=0,index2 =0;

                if(values[5].length()==1){
                    index2= valueOf(values[5]);
                    index1=index2-1;

                }
                else if(values[5].length()>1){
                    index1=Character.getNumericValue(values[5].charAt(0))-1;
                    index2=Character.getNumericValue(values[5].charAt(values[5].length()-1));
                }

                Book b=new Book(valueOf(values[0]), values[1], values[2], valueOf(values[3]),Boolean.parseBoolean(values[4]),
                                 authors.subList(index1,index2),(Registrator)employee);
                books.add(b);
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return books;
    }

    public List<Loan> readLoan(List<Book>books, List<Client> c, List<Employee> e){

        String path = "D:\\LABORATOARE EAP\\Library\\Loan.csv";
        List<Loan> loans=new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line=br.readLine())!=null) {
                String[] values = line.split(",");

                if(values.length >=3){
                    int a = parseInt(values[0]);
                    int b = parseInt(values[1]);
                    int cc = parseInt(values[2]);

                    Client clien=c.get(b);

                    Employee emplm=e.get(cc);
                    Librarian lib=new Librarian();
                    if(emplm instanceof Librarian){
                        lib=(Librarian)emplm;
                    }
                    Book bu =  books.get(a);

                    Loan l= new Loan(bu,clien,lib);
                    l.SetAvailability();
                    loans.add(l);
                }}
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return loans;
    }



}

