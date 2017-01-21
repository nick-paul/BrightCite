CREATE DATABASE brightcite;

USE brightcite;

CREATE TABLE site (
	siteID INT UNSIGNED NOT NULL AUTO_INCREMENT,
	url TEXT,
	siteRanking FLOAT NOT NULL DEFAULT 0,
	
	PRIMARY KEY(siteID),
	UNIQUE (siteID)
);

CREATE TABLE passage (
	passageID INT UNSIGNED NOT NULL AUTO_INCREMENT,
	siteID INT UNSIGNED NOT NULL DEFAULT 0,
	passageText TEXT,
	passageRanking FLOAT NOT NULL DEFAULT 0,

	PRIMARY KEY(passageID),
	UNIQUE (passageID)
);

CREATE TABLE citation (
	citationID INT UNSIGNED NOT NULL AUTO_INCREMENT,
	passageID INT UNSIGNED NOT NULL DEFAULT 0,
	source TEXT,
	passageIntegrity INT NOT NULL DEFAULT 0,
	flagCount INT NOT NULL DEFAULT 0,

	PRIMARY KEY(citationID),
	UNIQUE (citationID)
);

