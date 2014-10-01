/**
 * Created with IntelliJ IDEA.
 * Classes.User: roy
 * Date: 20.03.14
 * Time: 11:30
 * To change this template use File | Settings | File Templates.
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;

    public Product(int id, String name, String description, int quantity){
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString(){
        String str = "ID: " + id + "\tName: " + name + "\tDescription: " + description+ "\tQuantity: " + quantity;
        return str;
    }
}
