

public class Block {
    private int index;
    private String data;
    private String hash;
    private String previousHash;
    private static int totalBlock = 0;

    public Block(int index, String data, String previousHash) {
        if (index < 0) {
            throw new IllegalArgumentException("Index tidak boleh negatif.");
        }
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("Data tidak boleh kosong.");
        }
        if (previousHash == null || previousHash.trim().isEmpty()) {
            throw new IllegalArgumentException("Previous hash tidak boleh kosong.");
        }

        this.index = index;
        this.data = data;
        this.previousHash = previousHash;
        this.hash = countHash();
        totalBlock++;
    }
    // helper function
    public String countHash(){
        String hash = index + data + previousHash;
        return Integer.toString(hash.hashCode());
    }
    // getter
    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public int getIndex() {
        return index;
    }

    public String getData() {
        return data;
    }

    public static int getTotalBlock() {
        return totalBlock;
    }
    // setter
    public void setData(String data) {
        if (data == null || data.trim().isEmpty()) {
            System.out.println("Data tidak boleh kosong.");
            return;
        }
        this.data = data;
        // hitung ulang hash karena perubahan data
        this.hash = countHash();
        System.out.println("Data block berhasil diubah menjadi: " + this.data);
    }
    public void setIndex(int index) {
        if (index < 0) {
            System.out.println("Index tidak boleh negatif.");
            return;
        }
        this.index = index;
        // hitung ulang hash karena perubahan index
        this.hash = countHash();
        System.out.println("Index block berhasil diubah menjadi: " + this.index);
    }

    public void setPreviousHash(String previousHash) {
        if (previousHash == null || previousHash.trim().isEmpty()) {
            System.out.println("Previous hash tidak boleh kosong.");
            return;
        }
        this.previousHash = previousHash;
        // hitung ulang hash karena perubahan previousHash
        this.hash = countHash();
        System.out.println("Previous hash block berhasil diubah menjadi: " + this.previousHash);
    }

    public void getInfo() {
        System.out.println("Index: " + this.index);
        System.out.println("Data: " + this.data);
        System.out.println("Previous Hash: " + this.previousHash);
        System.out.println("Hash: " + this.hash);
    }
}
