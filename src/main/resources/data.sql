insert into CATEGORY (NAME)
    values ( '추리/미스테리' ),
           ( 'SF공상과학' ),
           ( '판타지' ),
           ( '스릴러' );

insert into book (CATEGORY_ID, NAME, STOCK, PRICE)
    VALUES ( 1, '꼭두각시 살인사건',
            20, 15500 ),
           ( 2, '천 개의 파랑',
            23, 14000 ),
           ( 3, 'test',
             10, 10000 );