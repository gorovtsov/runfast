DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS running_sessions;

CREATE TABLE users (
  id        BIGINT NOT NULL,
  login     VARCHAR(255) NOT NULL,
  password  VARCHAR(255) NOT NULL,
  name      VARCHAR(255) NOT NULL,
  surname   VARCHAR(255) NOT NULL

  CONSTRAINT PK_users PRIMARY KEY (id)
)

CREATE TABLE running_sessions (
  id BIGINT NOT NULL,
  distance VARCHAR(255) NOT NULL,
  start_time TIMESTAMP NOT NULL,
  finish_time TIMESTAMP NOT NULL,
  user_id BIGINT NOT NULL

  CONSTRAINT PK_running_sessions PRIMARY KEY (id),
  CONSTRAINT FK_running_sessions_users FOREIGN KEY (user_id) REFERENCES users(id)
)