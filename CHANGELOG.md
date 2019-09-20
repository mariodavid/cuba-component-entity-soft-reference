# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [0.6.0] - 2019-09-20

### Dependencies
- CUBA 7.1

## [0.5.1] - 2019-05-14

## Bugfix
- `SoftReferenceInstanceNameTableColumnGenerator` renders null references correctly instead of throwing an error

## [0.5.0] - 2019-02-23

## Added
- `SoftReferenceFormFieldGenerator` to render a soft reference into a CUBA 7 form component
- `SoftReferenceInstanceNameTableColumnGenerator` to render a soft reference with an instance name as a link into a table component

## Changed
- fixed entity import / export of entities containing a soft reference via entity inspector. The soft reference in the EntityLoadInfo output format is used.
- `EntitySoftReferenceDatatype` uses EntityLoadInfo output format: `example$Customer-2fdc4906-fa89-11e7-8c3f-9a214cf093ae`

### Dependencies
- CUBA 7

## [0.4.0] - 2018-10-31

### Dependencies
- CUBA 6.10.x

## [0.3.2] - 2018-07-20

### Changed
- removed wrong HSQLDB DB update scripts

## [0.3.1] - 2018-07-20 - Do not use! --> use 0.3.2 instead

### Changed
- NPE when referencing a metaclass which is not available anymore (#4)

## [0.3.0] - 2018-07-13

### Changed
- SoftReferenceServiceBean: implementation switched to Java for better interoperability (#1)

### Dependencies
- CUBA 6.9.x

## [0.2.0] - 2018-02-10

### Changed
- changed EntitySoftReferenceService API


## [0.1.0] - 2018-01-20

### Added
- EntitySoftReferenceConverter
- EntitySoftReferenceDatatype
- SoftReferenceService for data retrieval


### Dependencies
- CUBA 6.8.x
