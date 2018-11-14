create table Parking (
  TicketNumber INT not null,
  EntryTime timestamp,
  ExitTime timestamp,
  Fee float,
  PRIMARY KEY (TicketNumber)

  jdbcTemplate.execute(hsql);
);