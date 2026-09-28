import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Block[] chain = new Block[10];
        int jumlahBlock = 0;
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.printf("%n=== Menu Blockchain ===%n");
            System.out.printf("1. Tambah Block%n");
            System.out.printf("2. Tampilkan Block%n");
            System.out.printf("3. Cari Block%n");
            System.out.printf("4. Keluar%n");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahBlock >= chain.length) {
                        System.out.println("Rantai penuh, tidak bisa tambah block.");
                        break;
                    }
                    System.out.printf("Pilih tipe:%n1. Transaksi%n2. Data%n");
                    System.out.print("Tipe: ");
                    int tipe = scanner.nextInt();
                    scanner.nextLine();

                    String prev = (jumlahBlock == 0) ? "0" : chain[jumlahBlock - 1].getHash();
                    int idx = jumlahBlock;

                    if (tipe == 1) {
                        System.out.print("Data: ");
                        String data = scanner.nextLine();
                        System.out.print("Sender: ");
                        String sender = scanner.nextLine();
                        System.out.print("Receiver: ");
                        String receiver = scanner.nextLine();
                        System.out.print("Amount: ");
                        String amountStr = scanner.nextLine();
                        try {
                            double amount = Double.parseDouble(amountStr);
                            chain[jumlahBlock] = new BlockTransaction(sender, receiver, amount, idx, data, prev);
                            jumlahBlock++;
                            System.out.printf("Block transaksi ditambah. Hash: %s | Total: %d%n",
                                    chain[jumlahBlock - 1].getHash(), Block.getTotalBlock());
                        } catch (NumberFormatException e) {
                            System.out.println("Amount harus angka.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (tipe == 2) {
                        System.out.print("Data: ");
                        String data2 = scanner.nextLine();
                        System.out.print("Category: ");
                        String category = scanner.nextLine();
                        System.out.print("Owner: ");
                        String owner = scanner.nextLine();
                        try {
                            chain[jumlahBlock] = new BlockData(idx, data2, prev, category, owner);
                            jumlahBlock++;
                            System.out.printf("Block data ditambah. Hash: %s | Total: %d%n",
                                    chain[jumlahBlock - 1].getHash(), Block.getTotalBlock());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Tipe tidak valid.");
                    }
                    break;
                case 2:
                    if (jumlahBlock == 0) {
                        System.out.println("Belum ada block.");
                    } else {
                        System.out.printf("%n=== Daftar %d Block (Total dibuat: %d) ===%n",
                                jumlahBlock, Block.getTotalBlock());
                        for (int i = 0; i < jumlahBlock; i++) {
                            System.out.printf("--- Block ke-%d ---%n", (i + 1));
                            chain[i].getInfo();
                        }
                    }
                    break;
                case 3:
                    if (jumlahBlock == 0) {
                        System.out.println("Belum ada block.");
                        break;
                    }
                    System.out.printf("Cari berdasar:%n1. Index (angka)%n2. Data (teks)%n");
                    System.out.print("Pilih: ");
                    int mode = scanner.nextInt();
                    scanner.nextLine();
                    if (mode == 1) {
                        System.out.print("Masukkan index: ");
                        String sIdx = scanner.nextLine();
                        try {
                            int key = Integer.parseInt(sIdx);
                            cariBlock(key, chain, jumlahBlock);
                        } catch (NumberFormatException e) {
                            System.out.println("Index harus angka.");
                        }
                    } else if (mode == 2) {
                        System.out.print("Masukkan kata kunci data: ");
                        String key = scanner.nextLine();
                        cariBlock(key, chain, jumlahBlock);
                    } else {
                        System.out.println("Mode cari tidak valid.");
                    }
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
    }

    public static void cariBlock(int index, Block[] chain, int jumlahBlock) {
        boolean ketemu = false;
        for (int i = 0; i < jumlahBlock; i++) {
            if (chain[i].getIndex() == index) {
                System.out.printf("Ditemukan pada posisi ke-%d:%n", (i + 1));
                chain[i].getInfo();
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.printf("Block dengan index %d tidak ditemukan.%n", index);
        }
    }

    public static void cariBlock(String keyword, Block[] chain, int jumlahBlock) {
        boolean ketemu = false;
        for (int i = 0; i < jumlahBlock; i++) {
            if (chain[i].getData().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.printf("Ditemukan pada posisi ke-%d:%n", (i + 1));
                chain[i].getInfo();
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.printf("Block dengan kata kunci \"%s\" tidak ditemukan.%n", keyword);
        }
    }
}
