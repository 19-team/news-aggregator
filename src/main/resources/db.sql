-- init db

DROP TABLE IF EXISTS feed_items;
DROP TABLE IF EXISTS feed_channels;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS items_categories;

DROP SEQUENCE IF EXISTS glob_seq;
DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE glob_seq START 1;
CREATE SEQUENCE hibernate_sequence START 1;

-- Table "feed_channels"
CREATE TABLE feed_channels (
  id            INTEGER PRIMARY KEY DEFAULT nextval('glob_seq'),
  channel_link  VARCHAR(100) NOT NULL,
  channel_title VARCHAR(100) NOT NULL
);

CREATE UNIQUE INDEX channels_unique_link_idx
  ON feed_channels (channel_link);

-- Table "feed_items"
CREATE TABLE feed_items (
  id                    INTEGER PRIMARY KEY DEFAULT nextval('glob_seq'),
  feed_title            VARCHAR NOT NULL,
  feed_link             VARCHAR NOT NULL,
  feed_description      VARCHAR NOT NULL,
  feed_publication_date VARCHAR NOT NULL,
  feed_viewer_counts    VARCHAR NOT NULL,
  feed_channel_id       INTEGER NOT NULL,
  FOREIGN KEY (feed_channel_id) REFERENCES feed_channels (id) ON DELETE CASCADE
);

CREATE UNIQUE INDEX items_unique_link_idx
  ON feed_items (feed_link);

-- Table "categories"
CREATE TABLE categories (
  id            INTEGER PRIMARY KEY DEFAULT nextval('glob_seq'),
  category_name VARCHAR NOT NULL
);

CREATE UNIQUE INDEX categories_unique_link_idx
  ON categories (category_name);

-- Table "items_categories"
CREATE TABLE items_categories (
  item_id     INTEGER NOT NULL,
  category_id INTEGER NOT NULL,

  FOREIGN KEY (item_id) REFERENCES feed_items (id) ON DELETE CASCADE,
  FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE
);
