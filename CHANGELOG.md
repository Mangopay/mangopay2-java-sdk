## [Unreleased]
### Added
- ApplePay `Payin` methods are now available. More info about activation to come in the following weeks...
- New `Dispute` reason type `COUNTERFEIT_PRODUCT` has been added.

## [2.8.1] - 2019-09-09
### Added
- `GetEmoney` method now supports year and month parameters. More info on our [docs](https://docs.mangopay.com/endpoints/v2.01/user-emoney#e895_view-a-users-emoney)
### Fixed
- Fix content-length issue on UBODeclaration submission
- Migration to GSON

## [2.8.0] - 2019-08-29
### Added
- new [`UBODelaration`](https://docs.mangopay.com/endpoints/v2.01/ubo-declarations#e1024_the-ubo-declaration-object) submission system
- `CompanyNumber` support for [Legal `Users`](https://docs.mangopay.com/endpoints/v2.01/users#e259_create-a-legal-user)
### Fixed
Travis CI integration has ben fixed and ensure fast & secure package publishing on maven.org again.

 
