public class BlockData extends Block {
    private String category;
    private String owner;

    public BlockData(int index, String data, String previousHash,
                     String category, String owner) {
        super(index, data, previousHash);

        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty.");
        }
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner cannot be empty.");
        }

        this.category = category;
        this.owner = owner;
    }

    public String getCategory() {
        return category;
    }

    public String getOwner() {
        return owner;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            System.out.println("Category cannot be empty.");
            return;
        }
        this.category = category;
        System.out.println("Category successfully changed to: " + this.category);
    }

    public void setOwner(String owner) {
        if (owner == null || owner.trim().isEmpty()) {
            System.out.println("Owner cannot be empty.");
            return;
        }
        this.owner = owner;
        System.out.println("Owner successfully changed to: " + this.owner);
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Category: " + this.category);
        System.out.println("Owner: " + this.owner);
    }
}
