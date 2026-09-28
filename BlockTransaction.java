public class BlockTransaction extends Block {
    private String sender;
    private String receiver;
    private double amount;

    public BlockTransaction(String sender, String receiver, double amount, int index, String data, String previousHash) {
        super(index, data, previousHash);
        if (sender == null || sender.trim().isEmpty()) {
            throw new IllegalArgumentException("Sender tidak boleh kosong.");
        }
        if (receiver == null || receiver.trim().isEmpty()) {
            throw new IllegalArgumentException("Receiver tidak boleh kosong.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount harus lebih dari 0.");
        }
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setSender(String sender) {
        if (sender == null || sender.trim().isEmpty()) {
            throw new IllegalArgumentException("Sender tidak boleh kosong.");
        }
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        if (receiver == null || receiver.trim().isEmpty()) {
            throw new IllegalArgumentException("Receiver tidak boleh kosong.");
        }
        this.receiver = receiver;
    }

    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount harus lebih dari 0.");
        }
        this.amount = amount;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", amount=" + amount);
    }
}
