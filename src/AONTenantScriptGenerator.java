import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AONTenantScriptGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String addMore = "";
        List<String> output = new ArrayList<>();
        do {
            System.out.print("Enter tenant id by which directory is created (Ex- T13, T14): ");
            String logoTenant = sc.next();
            System.out.print("Enter color (Ex- RED, DARK_GREY): ");
            String color = sc.next();
            System.out.print("Enter unique internal tenant id (Ex- AAA, AAB): ");
            String uniqueTenantId = sc.next();
            System.out.print("Enter client tenant id: ");
            String clientTenantId = sc.next();
            String loylogicTenant = logoTenant + "_" + color + "_" + uniqueTenantId;
            String clientTenant = clientTenantId + "_" + color;
            output.add(makeThirdPartyEntries(clientTenant, loylogicTenant));
            output.add(makeIndexingQuery(loylogicTenant));
            output.add(makeThemeEntryQueries(loylogicTenant, "AONREX_" + logoTenant + "_" + color));
            System.out.print("Do you want to add more(y/n): ");
            addMore = sc.next();
        } while (addMore.charAt(0) == 'Y' || addMore.charAt(0) == 'y');
        for (String data : output) {
            System.out.println(data);
        }
    }

    private static String makeThemeEntryQueries(String loylogicTenant, String themeFolder) {
        String deleteQuery = "Delete from loyrewards_properties where config_key like '%"+loylogicTenant+"%' and program_code = 'AONREX';";
        String themeQuery = "Insert into loyrewards_properties (program_code,config_key,config_value,config_desc,context,config_module,module_desc,created_date,created_by,updated_date,updated_by,workflow_status) values\n" +
                "('AONREX','SHOP_THEME_"+loylogicTenant+"','"+themeFolder+"','Default theme for shop','LOYREWARDS','THEME_CONFIG','Configuration to load Theme Specific Properties',current_date,'FirojM',current_date,'FirojM','APR')\n" +
                ",('AONREX','EMAIL_THEME_"+loylogicTenant+"','"+themeFolder+"','Default theme for shop','LOYREWARDS','THEME_CONFIG','Configuration to load Theme Specific Properties',current_date,'FirojM',current_date,'FirojM','APR')\n" +
                ",('AONREX','SHOP_THEME_"+loylogicTenant+"','"+themeFolder+"','Default theme for shop','JOBS','THEME_CONFIG','Configuration to load Theme Specific Properties',current_date,'FirojM',current_date,'FirojM','APR')\n" +
                ",('AONREX','EMAIL_THEME_"+loylogicTenant+"','"+themeFolder+"','Default theme for shop','JOBS','THEME_CONFIG','Configuration to load Theme Specific Properties',current_date,'FirojM',current_date,'FirojM','APR')\n;";
        return deleteQuery + "\n" + themeQuery + "\n\n";
    }

    private static String makeIndexingQuery(String loylogicTenant) {
        final String indexingLPQuery = "Update loyrewards_properties set config_value = (select (config_value || '%s') from loyrewards_properties where config_key = 'lucene.segment.codes' and program_code = 'AONREX' and context = 'LOYREWARDS')\n" +
                "\twhere config_key = 'lucene.segment.codes' and program_code = 'AONREX';";
        loylogicTenant = "," + loylogicTenant;
        return String.format(indexingLPQuery, loylogicTenant) + "\n\n";
    }

    private static String makeThirdPartyEntries(String clientTenant, String loylogicTenant) {
        final String deleteQuery = "Delete from third_party_status_mapping where ext_status like '%"+clientTenant+"%' and program_code = 'AONREX';";
        final String thirdPartyEntry = "Insert into third_party_status_mapping (id,program_code,loy_status,ext_status,module,last_update_date) values\n" +
                "(nextval('third_party_status_map_seq'),'AONREX','%s','%s','ACCOUNT_STATUS',current_date);";
        List<String> countries = new ArrayList<>();
        countries.add("SGP");
        countries.add("PHL");
        countries.add("MYS");
        countries.add("IRL");
        countries.add("HKG");
        countries.add("GBR");
        countries.add("CHN");
        countries.add("CH");
        countries.add("CAN");
        StringBuilder sb = new StringBuilder(deleteQuery + "\n");
        for (String country : countries) {
            String clientTenantWithCountry = clientTenant + "_" + country;
            String finalQuery = String.format(thirdPartyEntry, loylogicTenant, clientTenantWithCountry);
            sb.append(finalQuery)
                    .append("\n");
        }
        return sb.append("\n")
                .toString();
    }
}