__PostgreSQL__

1) Start

        sudo -i -u postgres (mihal)
        psql

2) crate User

         CREATE USER postgres_user WITH PASSWORD 'password';
         alter role postgres_user superuser;
         \du

3) create , delete DB

         createdb test_db
         dropdb test_db
         \l

