# seting ssh komputer #

> ssh-keygen -t ed25519 -C "herdinoor369@gmail.com"

* nanti masukan tesk/code buat ssh nya

> eval "$(ssh-agent -s)"

> ssh-add ~/.ssh/id_ed25519

> cat ~/.ssh/id_ed25519.pub


# aplikasi invoice managment #

aplikasi ini dipakai untuk mengelolah invoice dan menyabungkan dengan berbagai metode pembayaran masa kini
diantaranya :

* virtual accaount bank
    * bank bni
    * bak cimb
    * bank bsi
* qris (e-wallet)


# cara setup database

1. jalankan postgresql di doker
   ...
   docker run --rm \
   --name invoice-db \
   -e POSTGRES_DB=invoicedb \
   -e POSTGRES_USER=invoice \
   -e POSTGRES_PASSWORD=invoice123 \
   -e PGDATA=/var/lib/postgresql/data/pgdata \
   -v $PWD/invoicedb-data:/var/lib/postgresql/data \
   -p 5432:5432 \
   postgres:13
   ...

2. jalankan db di terminal baru

   >  psql -h 127.0.0.1 -U invoice invoicedb

* setiap ada perubahan skema database. maka hapus database dengan cara menghapus folder invoicedb-data
* lalu jalankan ulang docker diikuti mvn
* 