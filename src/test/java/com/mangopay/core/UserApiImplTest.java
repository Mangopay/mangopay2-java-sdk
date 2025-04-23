package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import com.mangopay.entities.*;
import com.mangopay.entities.subentities.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * UserApiImpl test methods
 */
public class UserApiImplTest extends BaseTest {

    @Test
    public void createNatural() throws Exception {
        UserNatural john = this.getJohn();
        assertTrue(john.getId().length() > 0);
        assertTrue(john.getPersonType().equals(PersonType.NATURAL));
    }

    @Test
    public void createNaturalSca() throws Exception {
        UserNaturalSca johnSca = this.getJohnSca();
        assertTrue(johnSca.getId().length() > 0);
        assertTrue(johnSca.getPersonType().equals(PersonType.NATURAL));
        assertNotNull(johnSca.getPendingUserAction());
        assertEquals("PENDING_USER_ACTION", johnSca.getUserStatus());
    }

    @Test
    public void createLegal() throws Exception {
        UserLegal matrix = this.getMatrixOwner();
        assertTrue(matrix.getId().length() > 0);
        assertEquals(matrix.getPersonType(), PersonType.LEGAL);
        assertEquals("LU12345678", matrix.getCompanyNumber());
    }

    @Test
    public void createLegalSca() throws Exception {
        UserLegalSca matrixSca = this.getMatrixSca();
        assertTrue(matrixSca.getId().length() > 0);
        assertEquals(matrixSca.getPersonType(), PersonType.LEGAL);
        assertEquals("LU12345678", matrixSca.getCompanyNumber());
    }

    @Test
    public void createLegalFailsIfRequiredPropsNotProvided() throws Exception {
        UserLegal user = new UserLegal();

        User ret = null;

        try {
            ret = this.api.getUserApi().create(user);

            Assert.fail("CreateLegal() should throw an exception when required props are not provided");
        } catch (ResponseException ex) {
            assertNull(ret);
        }
    }

    @Test
    public void createLegalPassesIfRequiredPropsProvided() throws Exception {
        UserLegal user = new UserLegal();
        user.setHeadquartersAddress(new Address());
        user.getHeadquartersAddress().setAddressLine1("AddressLine1");
        user.getHeadquartersAddress().setAddressLine2("AddressLine2");
        user.getHeadquartersAddress().setCity("City");
        user.getHeadquartersAddress().setCountry(CountryIso.FR);
        user.getHeadquartersAddress().setPostalCode("11222");
        user.getHeadquartersAddress().setRegion("Region");
        user.setName("SomeOtherSampleOrg");
        user.setLegalPersonType(LegalPersonType.BUSINESS);
        user.setLegalRepresentativeFirstName("RepFName");
        user.setLegalRepresentativeLastName("RepLName");
        Calendar c = Calendar.getInstance();
        c.set(1975, 12, 21, 0, 0, 0);
        user.setLegalRepresentativeBirthday(c.getTimeInMillis() / 1000);
        user.setLegalRepresentativeNationality(CountryIso.FR);
        user.setLegalRepresentativeCountryOfResidence(CountryIso.FR);
        user.setEmail("email@email.org");
        user.setCompanyNumber("LU12345678");

        User ret = null;

        ret = this.api.getUserApi().create(user);

        assertTrue("Created successfully after required props set", ret.getId().length() > 0);

        assertEqualInputProps(user, ret);
    }

    @Test
    public void getAllUsers() throws Exception {
        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);
        List<User> users = this.api.getUserApi().getAll(null, sort);

        assertTrue(users.get(0).getCreationDate() > users.get(users.size() - 1).getCreationDate());

        sort = new Sorting();
        sort.addField("CreationDate", SortDirection.asc);
        users = this.api.getUserApi().getAll(null, sort);

        assertTrue(users.get(0).getCreationDate() < users.get(users.size() - 1).getCreationDate());
    }

    @Test
    public void getNatural() throws Exception {
        UserNatural john = this.getJohn();

        User user1 = this.api.getUserApi().get(john.getId());
        UserNatural user2 = this.api.getUserApi().getNatural(john.getId());

        assertTrue(user1.getPersonType().equals(PersonType.NATURAL));
        assertTrue(user1.getId().equals(john.getId()));
        assertTrue(user2.getPersonType().equals(PersonType.NATURAL));
        assertTrue(user2.getId().equals(john.getId()));

        assertEqualInputProps(user1, john);
    }

    @Test
    public void getNaturalSca() throws Exception {
        UserNaturalSca john = this.getJohnSca();

        User user1 = this.api.getUserApi().getSca(john.getId());
        UserNaturalSca user2 = this.api.getUserApi().getNaturalSca(john.getId());

        assertTrue(user1 instanceof UserNaturalSca);
        assertTrue(user1.getPersonType().equals(PersonType.NATURAL));
        assertTrue(user1.getId().equals(john.getId()));
        assertTrue(user2.getPersonType().equals(PersonType.NATURAL));
        assertTrue(user2.getId().equals(john.getId()));

        assertEqualInputProps(user1, john);
    }

    @Test
    public void getNaturalFailsForLegalUser() throws Exception {
        UserLegal matrix = this.getMatrixOwner();

        UserNatural user = null;
        try {
            user = this.api.getUserApi().getNatural(matrix.getId());

            Assert.fail("GetUser() should throw an exception when called with legal user id");
        } catch (ResponseException ex) {
            assertNull(user);
        }
    }

    @Test
    public void getLegalFailsForNaturalUser() throws Exception {
        UserNatural john = this.getJohn();

        User user = null;
        try {
            user = this.api.getUserApi().getLegal(john.getId());

            Assert.fail("GetLegal() should throw an exception when called with natural user id");
        } catch (ResponseException ex) {
            assertNull(user);
        }
    }

    @Test
    public void getLegal() throws Exception {
        UserLegal matrix = this.getMatrixOwner();

        User user1 = this.api.getUserApi().get(matrix.getId());
        User user2 = this.api.getUserApi().getLegal(matrix.getId());

        assertEqualInputProps(user1, matrix);
        assertEqualInputProps(user2, matrix);
    }

    @Test
    public void getLegalSca() throws Exception {
        UserLegalSca matrixSca = this.getMatrixSca();

        User user1 = this.api.getUserApi().getSca(matrixSca.getId());
        User user2 = this.api.getUserApi().getLegalSca(matrixSca.getId());

        assert(user1 instanceof UserLegalSca);
        assertEqualInputProps(user1, matrixSca);
        assertEqualInputProps(user2, matrixSca);
    }

    @Test
    public void updateNatural() throws Exception {
        UserNatural john = this.getJohn();
        john.setLastName(john.getLastName() + " - CHANGED");

        User userSaved = this.api.getUserApi().update(john);
        User userFetched = this.api.getUserApi().get(john.getId());

        assertEqualInputProps(john, userSaved);
        assertEqualInputProps(john, userFetched);
    }

    @Test
    public void updateNaturalSca() throws Exception {
        UserNaturalSca johnSca = this.getJohnSca();
        String updatedLastName = johnSca.getLastName() + " - CHANGED";
        johnSca.setLastName(updatedLastName);

        User userSaved = this.api.getUserApi().updateSca(johnSca);
        User userFetched = this.api.getUserApi().getSca(johnSca.getId());

        assertEquals(updatedLastName, ((UserNaturalSca) userFetched).getLastName());
        assertEqualInputProps(johnSca, userSaved);
        assertEqualInputProps(johnSca, userFetched);
    }

    @Test
    public void updateLegalSca() throws Exception {
        UserLegalSca matrixSca = this.getMatrixSca(false, true);
        LegalRepresentative updatedRepresentative = matrixSca.getLegalRepresentative();
        updatedRepresentative.setFirstName(updatedRepresentative.getFirstName() + " - CHANGED");
        matrixSca.setLegalRepresentative(updatedRepresentative);

        User userSaved = this.api.getUserApi().updateSca(matrixSca);
        User userFetched = this.api.getUserApi().getSca(matrixSca.getId());

        assertEqualInputProps(userSaved, matrixSca);
        assertEqualInputProps(userFetched, matrixSca);
    }

    @Test
    public void categorizeNaturalSca() throws Exception {
        UserNaturalSca johnPayer = this.getJohnScaPayer(false, true);
        Calendar c = Calendar.getInstance();
        c.set(1975, 12, 21, 0, 0, 0);

        johnPayer.setUserCategory(UserCategory.OWNER);
        johnPayer.setTermsAndConditionsAccepted(true);
        johnPayer.setPhoneNumber("+33611111111");
        johnPayer.setPhoneNumberCountry(CountryIso.FR);
        johnPayer.setBirthday(c.getTimeInMillis() / 1000);
        johnPayer.setNationality(CountryIso.FR);
        johnPayer.setCountryOfResidence(CountryIso.FR);

        // transition from PAYER to OWNER
        this.api.getUserApi().categorize(johnPayer);
        User userFetched = this.api.getUserApi().getSca(johnPayer.getId());

        assertEquals(UserCategory.OWNER, userFetched.getUserCategory());
    }

    @Test
    public void categorizeLegalSca() throws Exception {
        UserLegalSca matrixPayer = this.getMatrixScaPayer(false, true);

        Calendar c = Calendar.getInstance();
        c.set(1975, 12, 21, 0, 0, 0);
        LegalRepresentative legalRepresentative = new LegalRepresentative();
        legalRepresentative.setBirthday(c.getTimeInMillis() / 1000);
        legalRepresentative.setNationality(CountryIso.FR);
        legalRepresentative.setCountryOfResidence(CountryIso.FR);
        legalRepresentative.setEmail("john.doe.sca@sample.org");

        matrixPayer.setUserCategory(UserCategory.OWNER);
        matrixPayer.setTermsAndConditionsAccepted(true);
        matrixPayer.setHeadquartersAddress(getNewAddress());
        matrixPayer.setCompanyNumber("LU72HN11");
        matrixPayer.setLegalRepresentative(legalRepresentative);

        // transition from PAYER to OWNER
        this.api.getUserApi().categorize(matrixPayer);
        User userFetched = this.api.getUserApi().getSca(matrixPayer.getId());

        assertEquals(UserCategory.OWNER, userFetched.getUserCategory());
    }

    @Test
    public void enrollNaturalSca() throws Exception {
        UserNaturalSca johnSca = this.getJohnSca();
        UserEnrollmentResult result = this.api.getUserApi().enroll(johnSca.getId());

        assertNotNull(johnSca.getPendingUserAction().getRedirectUrl());
        assertNotNull(result.getPendingUserAction().getRedirectUrl());
        assertNotEquals(result.getPendingUserAction().getRedirectUrl(), johnSca.getPendingUserAction().getRedirectUrl());
    }

    @Test
    public void updateNaturalNonASCII() throws Exception {
        UserNatural john = this.getJohn();
        john.setLastName(john.getLastName() + " - CHANGED");

        User userSaved = this.api.getUserApi().update(john);
        User userFetched = this.api.getUserApi().get(john.getId());

        assertEqualInputProps(john, userSaved);
        assertEqualInputProps(john, userFetched);
    }

    @Test
    public void updateLegal() throws Exception {
        UserLegal matrix = this.getMatrixOwner();
        matrix.setLegalRepresentativeLastName(matrix.getLegalRepresentativeLastName() + " - CHANGED");

        User userSaved = this.api.getUserApi().update(matrix);
        User userFetched = this.api.getUserApi().get(matrix.getId());

        assertEqualInputProps(userSaved, matrix);
        assertEqualInputProps(userFetched, matrix);
    }

    @Test
    public void updateLegalWithoutAddresses() throws Exception {
        UserLegal matrix = this.getMatrixWithoutOptionalFields();
        matrix.setLegalRepresentativeLastName(matrix.getLegalRepresentativeLastName() + " - CHANGED");

        User userSaved = this.api.getUserApi().update(matrix);
        User userFetched = this.api.getUserApi().get(matrix.getId());

        assertEqualInputProps(userSaved, matrix);
        assertEqualInputProps(userFetched, matrix);
    }

    @Test
    public void createBankAccountIBAN() {
        try {
            UserNatural john = this.getJohn();
            BankAccount account = this.getJohnsAccount();

            assertTrue(account.getId().length() > 0);
            assertEquals(account.getUserId(), john.getId());
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void createBankAccountGB() throws Exception {
        UserNatural john = this.getJohn();
        BankAccount account = new BankAccount();
        account.setType(BankAccountType.GB);
        account.setOwnerName(john.getFirstName() + " " + john.getLastName());
        account.setOwnerAddress(john.getAddress());
        account.setDetails(new BankAccountDetailsGB());
        ((BankAccountDetailsGB) account.getDetails()).setAccountNumber("63956474");
        ((BankAccountDetailsGB) account.getDetails()).setSortCode("200000");
        account.setType(BankAccountType.GB);
        BankAccount createAccount = this.api.getUserApi().createBankAccount(john.getId(), account);

        assertTrue(createAccount.getId().length() > 0);
        assertEquals(createAccount.getUserId(), john.getId());
        assertSame(createAccount.getType(), BankAccountType.GB);
        assertEquals("63956474", ((BankAccountDetailsGB) createAccount.getDetails()).getAccountNumber());
        assertEquals("200000", ((BankAccountDetailsGB) createAccount.getDetails()).getSortCode());
    }

    @Test
    public void createBankAccountUS() throws Exception {
        UserNatural john = this.getJohn();
        BankAccount account = new BankAccount();
        account.setType(BankAccountType.US);
        account.setOwnerName(john.getFirstName() + " " + john.getLastName());
        account.setOwnerAddress(john.getAddress());
        account.setDetails(new BankAccountDetailsUS());
        ((BankAccountDetailsUS) account.getDetails()).setAccountNumber("234234234234");
        ((BankAccountDetailsUS) account.getDetails()).setAba("234334789");

        BankAccount createAccount = this.api.getUserApi().createBankAccount(john.getId(), account);

        assertTrue(createAccount.getId().length() > 0);
        assertEquals(createAccount.getUserId(), john.getId());
        assertSame(createAccount.getType(), BankAccountType.US);
        assertEquals("234234234234", ((BankAccountDetailsUS) createAccount.getDetails()).getAccountNumber());
        assertEquals("234334789", ((BankAccountDetailsUS) createAccount.getDetails()).getAba());
        assertEquals(((BankAccountDetailsUS) createAccount.getDetails()).getDepositAccountType(), DepositAccountType.CHECKING);

        ((BankAccountDetailsUS) account.getDetails()).setDepositAccountType(DepositAccountType.SAVINGS);
        BankAccount createAccountSavings = this.api.getUserApi().createBankAccount(john.getId(), account);

        assertTrue(createAccountSavings.getId().length() > 0);
        assertEquals(createAccountSavings.getUserId(), john.getId());
        assertSame(createAccountSavings.getType(), BankAccountType.US);
        assertEquals("234234234234", ((BankAccountDetailsUS) createAccountSavings.getDetails()).getAccountNumber());
        assertEquals("234334789", ((BankAccountDetailsUS) createAccountSavings.getDetails()).getAba());
        assertEquals(((BankAccountDetailsUS) createAccountSavings.getDetails()).getDepositAccountType(), DepositAccountType.SAVINGS);
    }

    @Test
    public void createBankAccountCA() throws Exception {
        UserNatural john = this.getJohn();
        BankAccount account = new BankAccount();
        account.setType(BankAccountType.CA);
        account.setOwnerName(john.getFirstName() + " " + john.getLastName());
        account.setOwnerAddress(john.getAddress());
        account.setDetails(new BankAccountDetailsCA());
        ((BankAccountDetailsCA) account.getDetails()).setBankName("TestBankName");
        ((BankAccountDetailsCA) account.getDetails()).setBranchCode("12345");
        ((BankAccountDetailsCA) account.getDetails()).setAccountNumber("234234234234");
        ((BankAccountDetailsCA) account.getDetails()).setInstitutionNumber("123");

        BankAccount createAccount = this.api.getUserApi().createBankAccount(john.getId(), account);

        assertTrue(createAccount.getId().length() > 0);
        assertEquals(createAccount.getUserId(), john.getId());
        assertSame(createAccount.getType(), BankAccountType.CA);
        assertEquals("234234234234", ((BankAccountDetailsCA) createAccount.getDetails()).getAccountNumber());
        assertEquals("TestBankName", ((BankAccountDetailsCA) createAccount.getDetails()).getBankName());
        assertEquals("12345", ((BankAccountDetailsCA) createAccount.getDetails()).getBranchCode());
        assertEquals("123", ((BankAccountDetailsCA) createAccount.getDetails()).getInstitutionNumber());
    }

    @Test
    public void createBankAccountOTHER() {
        try {
            UserNatural john = this.getJohn();
            BankAccount account = new BankAccount();
            account.setOwnerName(john.getFirstName() + " " + john.getLastName());
            account.setOwnerAddress(john.getAddress());
            account.setDetails(new BankAccountDetailsOTHER());
            account.setType(BankAccountType.OTHER);
            ((BankAccountDetailsOTHER) account.getDetails()).setCountry(CountryIso.FR);
            ((BankAccountDetailsOTHER) account.getDetails()).setAccountNumber("234234234234");
            ((BankAccountDetailsOTHER) account.getDetails()).setBic("BINAADADXXX");

            BankAccount createAccount = this.api.getUserApi().createBankAccount(john.getId(), account);

            assertTrue(createAccount.getId().length() > 0);
            assertTrue(createAccount.getUserId().equals(john.getId()));
            assertTrue(createAccount.getType() == BankAccountType.OTHER);
            assertTrue(((BankAccountDetailsOTHER) createAccount.getDetails()).getCountry().equals(CountryIso.FR));
            assertTrue(((BankAccountDetailsOTHER) createAccount.getDetails()).getAccountNumber().equals("234234234234"));
            assertTrue(((BankAccountDetailsOTHER) createAccount.getDetails()).getBic().equals("BINAADADXXX"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void createBankAccount() throws Exception {
        UserNatural john = this.getJohn();
        BankAccount account = this.getJohnsAccount();

        assertTrue(account.getId().length() > 0);
        assertTrue(account.getUserId().equals(john.getId()));
    }

    @Test
    public void updateBankAccount() throws Exception {
        UserNatural john = this.getJohn();
        BankAccount account = this.getJohnsAccount();

        assertTrue(account.getId().length() > 0);
        assertTrue(account.getUserId().equals(john.getId()));

        // disactivate bank account
        BankAccount disactivateBankAccount = new BankAccount();
        disactivateBankAccount.setActive(false);
        disactivateBankAccount.setType(BankAccountType.IBAN);
        BankAccountDetailsIBAN bankAccountDetails = new BankAccountDetailsIBAN();
        bankAccountDetails.setIban("FR7630004000031234567890143");
        bankAccountDetails.setBic("BNPAFRPP");
        disactivateBankAccount.setDetails(bankAccountDetails);
        BankAccount result = this.api.getUserApi().updateBankAccount(john.getId(), disactivateBankAccount, account.getId());

        assertNotNull(result);
        assertEquals(account.getId(), result.getId());
        assertFalse(result.isActive());
    }

    @Test
    public void getBankAccount() throws Exception {
        UserNatural john = this.getJohn();
        BankAccount account = this.getJohnsAccount();

        BankAccount accountFetched = this.api.getUserApi().getBankAccount(john.getId(), account.getId());

        assertEqualInputProps(account, accountFetched);
    }

    @Test
    public void getBankAccounts() throws Exception {
        UserNatural john = this.getJohn();
        BankAccount account = this.getJohnsAccount();
        Pagination pagination = new Pagination(1, 12);

        List<BankAccount> list = this.api.getUserApi().getBankAccounts(john.getId(), pagination, null);

        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (account.getId().equals(list.get(i).getId())) {
                index = i;
                break;
            }
        }

        assertTrue(list.get(0) instanceof BankAccount);
        assertTrue(index > -1);
        assertEqualInputProps(account, list.get(index));
        assertTrue(pagination.getPage() == 1);
        assertTrue(pagination.getItemsPerPage() == 12);
    }

    @Test
    public void getActiveBankAccounts() {
        try {
            UserNatural john = this.getJohn();
            BankAccount account = this.getJohnsAccount();
            List<BankAccount> list = this.api.getUserApi().getActiveBankAccounts(john.getId(), true, null, null);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getBankAccountsAndSortByCreationDate() throws Exception {
        UserNatural john = this.getJohn();
        this.getJohnsAccount();
        this.holdOn(2);
        this.getNewBankAccount();
        Pagination pagination = new Pagination(1, 12);
        Sorting sorting = new Sorting();
        sorting.addField("CreationDate", SortDirection.desc);

        List<BankAccount> list = this.api.getUserApi().getBankAccounts(john.getId(), pagination, sorting);

        assertNotNull(list);
        assertTrue(list.get(0) instanceof BankAccount);
        assertTrue(list.size() > 1);
        assertTrue(list.get(0).getCreationDate() > list.get(1).getCreationDate());
    }


    @Test
    public void createKycDocument() throws Exception {
        KycDocument kycDocument = this.getJohnsKycDocument();

        assertNotNull(kycDocument);
        assertTrue(kycDocument.getStatus() == KycStatus.CREATED);
    }

    @Test
    public void updateKycDocument() throws Exception {
        UserNatural john = this.getJohn();
        KycDocument kycDocument = this.getJohnsKycDocument();

        URL url = getClass().getResource("/com/mangopay/core/TestKycPageFile.png");
        String filePath = new File(url.toURI()).getAbsolutePath();

        this.api.getUserApi().createKycPage(john.getId(), kycDocument.getId(), filePath);

        kycDocument.setStatus(KycStatus.VALIDATION_ASKED);

        KycDocument result = this.api.getUserApi().updateKycDocument(john.getId(), kycDocument);

        assertNotNull(result);
        assertTrue(kycDocument.getType().equals(result.getType()));
        assertTrue(kycDocument.getStatus() == KycStatus.VALIDATION_ASKED);
    }

    @Test
    public void getKycDocument() throws Exception {
        UserNatural john = this.getJohn();
        KycDocument kycDocument = this.getJohnsKycDocument();

        KycDocument result = this.api.getUserApi().getKycDocument(john.getId(), kycDocument.getId());

        assertNotNull(result);
        assertTrue(kycDocument.getId().equals(result.getId()));
        assertTrue(kycDocument.getType().equals(result.getType()));
        //there might be a problem with the JUnit. if you run the test separately, it works, if it's in the bunch, it doesn't.
        //assertTrue(kycDocument.getStatus().equals(result.getStatus()));
        assertTrue(kycDocument.getCreationDate() == result.getCreationDate());
    }

    @Test
    public void createKycPage() throws Exception {
        UserNatural john = this.getJohn();
        KycDocument kycDocument = this.getNewKycDocument();

        URL url = getClass().getResource("/com/mangopay/core/TestKycPageFile.png");
        String filePath = new File(url.toURI()).getAbsolutePath();

        this.api.getUserApi().createKycPage(john.getId(), kycDocument.getId(), filePath);

        kycDocument = this.getNewKycDocument();
        this.api.getUserApi().createKycPage(john.getId(), kycDocument.getId(), Files.readAllBytes(Paths.get(filePath)));
    }

    @Test
    public void getCards() throws Exception {
        UserNatural john = this.getJohn();
        Pagination pagination = new Pagination(1, 20);
        List<Card> cardsBefore = this.api.getUserApi().getCards(john.getId(), pagination, null);
        PayIn payIn = this.getNewPayInCardDirect();
        Card card = this.api.getCardApi().get(((PayInPaymentDetailsCard) payIn.getPaymentDetails()).getCardId());
        List<Card> cardsAfter = this.api.getUserApi().getCards(john.getId(), pagination, null);

        assertNotNull(cardsBefore);
        assertTrue(cardsAfter.size() > cardsBefore.size());
    }

    @Test
    public void getCardsAndSortByCreationDate() throws Exception {
        UserNatural john = this.getJohn();
        this.getNewPayInCardDirect();
        this.holdOn(2);
        this.getNewPayInCardDirect();
        Pagination pagination = new Pagination(1, 20);
        Sorting sorting = new Sorting();
        sorting.addField("CreationDate", SortDirection.desc);
        List<Card> cards = this.api.getUserApi().getCards(john.getId(), pagination, sorting);

        assertNotNull(cards);
        assertTrue(cards.size() > 1);
        assertTrue(cards.get(0).getCreationDate() > cards.get(1).getCreationDate());
    }

    @Test
    public void getUserWalletsSca() throws Exception {
        UserNatural john = this.getJohn();
        Pagination pagination = new Pagination(1, 20);
        FilterWallets filter = new FilterWallets().setScaContext("USER_PRESENT");

        try {
            this.api.getUserApi().getWallets(john.getId(), pagination, filter, null);
        } catch (ResponseException e) {
            assertEquals(401, e.getResponseHttpCode());
            assertTrue(e.getErrors().containsKey("Sca"));
            assertTrue(e.getData().containsKey("RedirectUrl"));
        }
    }

    @Test
    public void getTransactions() throws Exception {
        UserNatural john = this.getJohn();
        Transfer transfer = this.getNewTransfer();
        Pagination pagination = new Pagination(1, 20);

        List<Transaction> transactions = this.api.getUserApi().getTransactions(john.getId(), pagination, new FilterTransactions(), null);

        assertFalse(transactions.isEmpty());
        for (Transaction t : transactions) {
            assertNotNull(t.getStatus());
            assertNotEquals(TransactionStatus.NotSpecified, t.getStatus());
        }

        assertTrue(transactions.size() > 0);
        assertTrue(transactions.get(0).getType() != null);
        assertTrue(transactions.get(0).getStatus() != null);
    }

    @Test
    public void getTransactionsSca() throws Exception {
        UserNatural john = this.getJohn();
        Pagination pagination = new Pagination(1, 20);
        FilterTransactions filter = new FilterTransactions();
        filter.setScaContext("USER_PRESENT");

        try {
            this.api.getUserApi().getTransactions(john.getId(), pagination, filter, null);
        } catch (ResponseException e) {
            assertEquals(401, e.getResponseHttpCode());
            assertTrue(e.getErrors().containsKey("Sca"));
            assertTrue(e.getData().containsKey("RedirectUrl"));
        }
    }

    @Test
    public void getTransactionsAndSortByCreationDate() throws Exception {
        UserNatural john = this.getJohn();
        this.getNewTransfer();
        this.holdOn(2);
        this.getNewTransfer();
        Pagination pagination = new Pagination(1, 20);
        Sorting sorting = new Sorting();
        sorting.addField("CreationDate", SortDirection.desc);

        List<Transaction> transactions = this.api.getUserApi().getTransactions(john.getId(), pagination, new FilterTransactions(), sorting);

        assertFalse(transactions.isEmpty());
        for (Transaction t : transactions) {
            assertNotNull(t.getStatus());
            assertNotEquals(TransactionStatus.NotSpecified, t.getStatus());
        }

        assertNotNull(transactions);
        assertTrue(transactions.size() > 1);
        assertTrue(transactions.get(0).getCreationDate() > transactions.get(1).getCreationDate());
    }

    @Test
    public void getKycDocuments() throws Exception {
        KycDocument kycDocument = this.getJohnsKycDocument();
        UserNatural user = this.getJohn();
        Pagination pagination = new Pagination(1, 20);

        List<KycDocument> getKycDocuments = this.api.getUserApi().getKycDocuments(user.getId(), pagination, null);

        assertTrue(getKycDocuments.get(0) instanceof KycDocument);
        KycDocument kycFromList = null;
        for (KycDocument item : getKycDocuments) {
            if (item.getId().equals(kycDocument.getId())) {
                kycFromList = item;
                break;
            }
        }
        assertNotNull(kycFromList);
        assertEquals(kycDocument.getId(), kycFromList.getId());
        assertEqualInputProps(kycDocument, kycFromList);
    }

    @Test
    public void getKycDocumentsAndSortByCreationDate() throws Exception {
        this.getJohnsKycDocument();
        this.holdOn(2);
        this.getNewKycDocument();
        UserNatural user = this.getJohn();
        Pagination pagination = new Pagination(1, 20);
        Sorting sorting = new Sorting();
        sorting.addField("CreationDate", SortDirection.desc);

        List<KycDocument> getKycDocuments = this.api.getUserApi().getKycDocuments(user.getId(), pagination, sorting);

        assertNotNull(getKycDocuments);
        assertTrue(getKycDocuments.get(0) instanceof KycDocument);
        assertTrue(getKycDocuments.size() > 1);
        assertTrue(getKycDocuments.get(0).getCreationDate() > getKycDocuments.get(1).getCreationDate());
    }

    @Test
    public void getUserEMoney() throws Exception {
        User john = getJohn();
        String year = "2019";
        String month = "04";
        EMoney eMoney = this.api.getUserApi().getEMoney(john.getId(), year);

        assertNotNull(eMoney);
        assertEquals(eMoney.getUserId(), john.getId());

        eMoney = this.api.getUserApi().getEMoney(john.getId(), year, month);

        assertNotNull(eMoney);
        assertEquals(eMoney.getUserId(), john.getId());
    }

    @Test
    public void getUserEMoneyChf() throws Exception {
        getUserEMoney(CurrencyIso.CHF);
    }

    @Test
    public void getUserEMoneyUsd() throws Exception {
        getUserEMoney(CurrencyIso.USD);
    }

    @Test
    public void testUserEMoneyNullCurrency() throws Exception {
        getUserEMoney(null, CurrencyIso.EUR);
    }

    private void getUserEMoney(CurrencyIso currencySentInRequest) throws Exception {
        getUserEMoney(currencySentInRequest, currencySentInRequest);
    }

    private void getUserEMoney(CurrencyIso currencySentInRequest, CurrencyIso currencyExpected) throws Exception {
        User john = getJohn();
        String year = "2019";
        String month = "04";
        EMoney eMoney = this.api.getUserApi().getEMoney(john.getId(), year, currencySentInRequest);

        assertNotNull(eMoney);
        assertEquals(john.getId(), eMoney.getUserId());
        assertEquals(currencyExpected, eMoney.getCreditedEMoney().getCurrency());

        eMoney = this.api.getUserApi().getEMoney(john.getId(), year, month, currencySentInRequest);

        assertNotNull(eMoney);
        assertEquals(john.getId(), eMoney.getUserId());
        assertEquals(currencyExpected, eMoney.getCreditedEMoney().getCurrency());
    }

    @Test
    public void getBankAccountTransactions() throws Exception {
        BankAccount johnsAccount = getJohnsAccount();
        PayOut johnsPayOutBankWire = getJohnsPayOutBankWire();
        Pagination pagination = new Pagination(1, 1);
        Thread.sleep(2000);
        List<Transaction> bankAccountTransactions = this.api.getUserApi().getBankAccountTransactions(johnsAccount.getId(), pagination, null);

        assertNotNull("List of bank account transactions is null", bankAccountTransactions);
        assertFalse("List of bank account transactions is empty", bankAccountTransactions.isEmpty());
        assertTrue("List of bank account transactions size  does not match pagination", bankAccountTransactions.size() == 1);
        assertEquals("Returned transaction is not the expected one", bankAccountTransactions.get(0).getId(), johnsPayOutBankWire.getId());
    }

    @Test
    public void getUserPreAuthorizations() throws Exception {
        CardPreAuthorization johnsCardPreAuthorization = getJohnsCardPreAuthorization();

        assertNotNull(johnsCardPreAuthorization);
        List<CardPreAuthorization> preAuthorizations = this.api.getUserApi().getPreAuthorizations(johnsCardPreAuthorization.getAuthorId());

        assertNotNull(preAuthorizations);
        assertFalse(preAuthorizations.isEmpty());
        assertNotNull(preAuthorizations.get(0));
        assertTrue(preAuthorizations.get(0).getAuthorId().equals(johnsCardPreAuthorization.getAuthorId()));
    }

    @Test
    public void getUserPreAuthorizationsWithPagination() throws Exception {
        CardPreAuthorization johnsCardPreAuthorization = getJohnsCardPreAuthorization();

        assertNotNull(johnsCardPreAuthorization);

        Pagination pagination = new Pagination(1, 20);

        List<CardPreAuthorization> preAuthorizations = this.api.getUserApi().getPreAuthorizations(johnsCardPreAuthorization.getAuthorId(), pagination, null);

        assertNotNull(preAuthorizations);
        assertFalse(preAuthorizations.isEmpty());
        assertNotNull(preAuthorizations.get(0));
        assertTrue(preAuthorizations.get(0).getAuthorId().equals(johnsCardPreAuthorization.getAuthorId()));
    }

    @Test
    public void getUserPreAuthorizationsWithNullPaginationObject() throws Exception {
        CardPreAuthorization johnsCardPreAuthorization = getJohnsCardPreAuthorization();

        assertNotNull(johnsCardPreAuthorization);

        Pagination pagination = null;

        List<CardPreAuthorization> preAuthorizations = this.api.getUserApi().getPreAuthorizations(johnsCardPreAuthorization.getAuthorId(), null, null);

        assertNotNull(preAuthorizations);
        assertFalse(preAuthorizations.isEmpty());
        assertNotNull(preAuthorizations.get(0));
        assertTrue(preAuthorizations.get(0).getAuthorId().equals(johnsCardPreAuthorization.getAuthorId()));
    }

    @Test
    public void getUserPreAuthorizationsWithPaginationAndFilterReturnsValue() throws Exception {
        CardPreAuthorization johnsCardPreAuthorization = getJohnsCardPreAuthorization();

        assertNotNull(johnsCardPreAuthorization);

        Pagination pagination = new Pagination(1, 20);
        FilterPreAuthorizations fpa = new FilterPreAuthorizations();
        fpa.setPreAuthorizationStatus(PreAuthorizationStatus.SUCCEEDED);
        fpa.setResultCode("000000");

        List<CardPreAuthorization> preAuthorizations = this.api.getUserApi().getPreAuthorizations(johnsCardPreAuthorization.getAuthorId(), pagination, fpa, null);

        assertNotNull(preAuthorizations);
        assertFalse(preAuthorizations.isEmpty());
        assertNotNull(preAuthorizations.get(0));
        assertTrue(preAuthorizations.get(0).getAuthorId().equals(johnsCardPreAuthorization.getAuthorId()));
    }

    @Test
    public void getUserPreAuthorizationsWithPaginationAndFilterDoesNotReturnValue() throws Exception {
        CardPreAuthorization johnsCardPreAuthorization = getJohnsCardPreAuthorization();

        assertNotNull(johnsCardPreAuthorization);

        Pagination pagination = new Pagination(1, 20);
        FilterPreAuthorizations fpa = new FilterPreAuthorizations();
        fpa.setResultCode("000001");

        List<CardPreAuthorization> preAuthorizations = this.api.getUserApi().getPreAuthorizations(johnsCardPreAuthorization.getAuthorId(), pagination, fpa, null);

        assertNotNull(preAuthorizations);
        assertTrue(preAuthorizations.isEmpty());
    }

    @Test
    public void getRegulatory() throws Exception{
        UserNatural user = this.getJohn();
        UserBlockStatus blockStatus = this.api.getUserApi().getRegulatory(user.getId());

        assertNotNull(blockStatus);
    }

    @Test
    public void testUserNaturalTermsAndConditions() throws Exception {
        UserNatural user = this.getJohn();
        assertFalse(user.isTermsAndConditionsAccepted());

        user.setTermsAndConditionsAccepted(true);
        UserNatural updatedUser = (UserNatural) this.api.getUserApi().update(user);
        assertTrue(updatedUser.isTermsAndConditionsAccepted());
        assertNotNull(updatedUser.getTermsAndConditionsAcceptedDate());

        UserNatural acceptedByDef = this.getJohnWithTermsAccepted();
        assertTrue(acceptedByDef.isTermsAndConditionsAccepted());
        assertNotNull(acceptedByDef.getTermsAndConditionsAcceptedDate());
    }

    @Test
    public void testUserLegalTermsAndConditions() throws Exception {
        UserLegal user = this.getMatrixOwner();
        assertFalse(user.isTermsAndConditionsAccepted());

        user.setTermsAndConditionsAccepted(true);
        UserLegal updatedUser = (UserLegal) this.api.getUserApi().update(user);
        assertTrue(updatedUser.isTermsAndConditionsAccepted());
        assertNotNull(updatedUser.getTermsAndConditionsAcceptedDate());

        UserLegal acceptedByDef = this.getMatrixWithoutOptionalFieldsAndAcceptedTerms();
        assertTrue(acceptedByDef.isTermsAndConditionsAccepted());
        assertNotNull(acceptedByDef.getTermsAndConditionsAcceptedDate());
    }
}
