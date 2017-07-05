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
    public void createLegal() throws Exception {
        UserLegal matrix = this.getMatrix();
        assertTrue(matrix.getId().length() > 0);
        assertTrue(matrix.getPersonType().equals(PersonType.LEGAL));
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
    public void getLegacyNatural() throws Exception {
        this.api.getConfig().setApiVersion(Configuration.VERSION_2);

        LegacyUserNatural legacyJohn = this.getLegacyJohn();
        User user1 = this.api.getLegacyUserApi().get(legacyJohn.getId());
        LegacyUserNatural user2 = this.api.getLegacyUserApi().getNatural(legacyJohn.getId());

        assertTrue(user1.getPersonType().equals(PersonType.NATURAL));
        assertTrue(user1.getId().equals(legacyJohn.getId()));
        assertTrue(user2.getPersonType().equals(PersonType.NATURAL));
        assertTrue(user2.getId().equals(legacyJohn.getId()));

        assertEqualInputProps(user1, legacyJohn);
    }

    @Test
    public void getLegal() throws Exception {
        UserLegal matrix = this.getMatrix();

        User user1 = this.api.getUserApi().get(matrix.getId());
        User user2 = this.api.getUserApi().getLegal(matrix.getId());

        assertEqualInputProps(user1, matrix);
        assertEqualInputProps(user2, matrix);
    }

    @Test
    public void getLegacyLegal() throws Exception {
        this.api.getConfig().setApiVersion(Configuration.VERSION_2);

        LegacyUserLegal legacyMatrix = this.getLegacyMatrix();

        User user1 = this.api.getLegacyUserApi().get(legacyMatrix.getId());
        User user2 = this.api.getLegacyUserApi().getLegal(legacyMatrix.getId());

        assertEqualInputProps(user1, legacyMatrix);
        assertEqualInputProps(user2, legacyMatrix);
    }

    @Test
    public void getNaturalFailsForLegalUser() throws Exception {
        UserLegal matrix = this.getMatrix();

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
    public void updateNatural() throws Exception {
        UserNatural john = this.getJohn();
        john.setLastName(john.getLastName() + " - CHANGED");

        User userSaved = this.api.getUserApi().update(john);
        User userFetched = this.api.getUserApi().get(john.getId());

        assertEqualInputProps(john, userSaved);
        assertEqualInputProps(john, userFetched);
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
        UserLegal matrix = this.getMatrix();
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
    public void createBankAccountGB() {
        try {
            UserNatural john = this.getJohn();
            BankAccount account = new BankAccount();
            account.setOwnerName(john.getFirstName() + " " + john.getLastName());
            account.setOwnerAddress(john.getAddress());
            account.setDetails(new BankAccountDetailsGB());
            ((BankAccountDetailsGB) account.getDetails()).setAccountNumber("63956474");
            ((BankAccountDetailsGB) account.getDetails()).setSortCode("200000");

            BankAccount createAccount = this.api.getUserApi().createBankAccount(john.getId(), account);

            assertTrue(createAccount.getId().length() > 0);
            assertTrue(createAccount.getUserId().equals(john.getId()));
            assertTrue(createAccount.getType() == BankAccountType.GB);
            assertTrue(((BankAccountDetailsGB) createAccount.getDetails()).getAccountNumber().equals("63956474"));
            assertTrue(((BankAccountDetailsGB) createAccount.getDetails()).getSortCode().equals("200000"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void createBankAccountUS() {
        try {
            UserNatural john = this.getJohn();
            BankAccount account = new BankAccount();
            account.setOwnerName(john.getFirstName() + " " + john.getLastName());
            account.setOwnerAddress(john.getAddress());
            account.setDetails(new BankAccountDetailsUS());
            ((BankAccountDetailsUS) account.getDetails()).setAccountNumber("234234234234");
            ((BankAccountDetailsUS) account.getDetails()).setAba("234334789");

            BankAccount createAccount = this.api.getUserApi().createBankAccount(john.getId(), account);

            assertTrue(createAccount.getId().length() > 0);
            assertTrue(createAccount.getUserId().equals(john.getId()));
            assertTrue(createAccount.getType() == BankAccountType.US);
            assertTrue(((BankAccountDetailsUS) createAccount.getDetails()).getAccountNumber().equals("234234234234"));
            assertTrue(((BankAccountDetailsUS) createAccount.getDetails()).getAba().equals("234334789"));
            assertTrue(((BankAccountDetailsUS) createAccount.getDetails()).getDepositAccountType().equals(DepositAccountType.CHECKING));

            ((BankAccountDetailsUS) account.getDetails()).setDepositAccountType(DepositAccountType.SAVINGS);
            BankAccount createAccountSavings = this.api.getUserApi().createBankAccount(john.getId(), account);

            assertTrue(createAccountSavings.getId().length() > 0);
            assertTrue(createAccountSavings.getUserId().equals(john.getId()));
            assertTrue(createAccountSavings.getType() == BankAccountType.US);
            assertTrue(((BankAccountDetailsUS) createAccountSavings.getDetails()).getAccountNumber().equals("234234234234"));
            assertTrue(((BankAccountDetailsUS) createAccountSavings.getDetails()).getAba().equals("234334789"));
            assertTrue(((BankAccountDetailsUS) createAccountSavings.getDetails()).getDepositAccountType().equals(DepositAccountType.SAVINGS));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void createBankAccountCA() {
        try {
            UserNatural john = this.getJohn();
            BankAccount account = new BankAccount();
            account.setOwnerName(john.getFirstName() + " " + john.getLastName());
            account.setOwnerAddress(john.getAddress());
            account.setDetails(new BankAccountDetailsCA());
            ((BankAccountDetailsCA) account.getDetails()).setBankName("TestBankName");
            ((BankAccountDetailsCA) account.getDetails()).setBranchCode("12345");
            ((BankAccountDetailsCA) account.getDetails()).setAccountNumber("234234234234");
            ((BankAccountDetailsCA) account.getDetails()).setInstitutionNumber("123");

            BankAccount createAccount = this.api.getUserApi().createBankAccount(john.getId(), account);

            assertTrue(createAccount.getId().length() > 0);
            assertTrue(createAccount.getUserId().equals(john.getId()));
            assertTrue(createAccount.getType() == BankAccountType.CA);
            assertTrue(((BankAccountDetailsCA) createAccount.getDetails()).getAccountNumber().equals("234234234234"));
            assertTrue(((BankAccountDetailsCA) createAccount.getDetails()).getBankName().equals("TestBankName"));
            assertTrue(((BankAccountDetailsCA) createAccount.getDetails()).getBranchCode().equals("12345"));
            assertTrue(((BankAccountDetailsCA) createAccount.getDetails()).getInstitutionNumber().equals("123"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
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
        try {
            UserNatural john = this.getJohn();
            BankAccount account = this.getJohnsAccount();

            assertTrue(account.getId().length() > 0);
            assertTrue(account.getUserId().equals(john.getId()));

            // disactivate bank account
            BankAccount disactivateBankAccount = new BankAccount();
            disactivateBankAccount.setActive(false);

            BankAccount result = this.api.getUserApi().updateBankAccount(john.getId(), disactivateBankAccount, account.getId());

            assertNotNull(result);
            assertTrue(account.getId().equals(result.getId()));
            assertFalse(result.isActive());
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
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
        assertTrue(kycDocument.getStatus().equals(result.getStatus()));
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
    public void getTransactions() throws Exception {
        UserNatural john = this.getJohn();
        Transfer transfer = this.getNewTransfer();
        Pagination pagination = new Pagination(1, 20);

        List<Transaction> transactions = this.api.getUserApi().getTransactions(john.getId(), pagination, new FilterTransactions(), null);

        assertTrue(transactions.size() > 0);
        assertTrue(transactions.get(0).getType() != null);
        assertTrue(transactions.get(0).getStatus() != null);
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

        EMoney eMoney = this.api.getUserApi().getEMoney(john.getId());

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

        EMoney eMoney = this.api.getUserApi().getEMoney(john.getId(), currencySentInRequest);

        assertNotNull(eMoney);
        assertEquals(john.getId(), eMoney.getUserId());
        assertEquals(currencyExpected, eMoney.getCreditedEMoney().getCurrency());
    }
}
