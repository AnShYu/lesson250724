package ru.andshir;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CurrencyCountryParser {

    public static void main(String[] args) {
        String input = "Ангола#AOA/Аргентина#ARS/Армения#AMD/Аруба#AWG/" +
                "Афганистан#AFN/Багамские острова#BSD/Бангладеш#BDT/" +
                "Барбадос#BBD/Бахрейн#BHD/Беларусь#BYR/Белиз#BZD/" +
                "Бермудские острова#BMD/Болгария#BGN/Боливия#BOB/" +
                "Босния и Герцеговина#BAM/Ботсвана#BWP/Бразилия#BRL/" +
                "Бруней#BND/Бурунди#BIF/Бутан#BTN/Вануату#VUV/Великобритания#GBP/" +
                "Венгрия#HUF/Венесуэла#VEB/Восточный Тимор; Индонезия#IDR/" +
                "Вьетнам#VND/Габон; Камерун; Конго; Центрально-Африканская Республика; Чад; Экваториальная Гвинея#XAF/" +
                "Гаити#HTG/Гайана#GYD/Гамбия#GMD/Колумбия#COP/Коморские острова#KMF/Коста-Рика#CRC/Куба#CUP";


        CurrencyCountryParser ccp = new CurrencyCountryParser();

        Map<String, String> currencyCountryMap = ccp.makeCurrencyCountryMap(input);
        for (String key: currencyCountryMap.keySet()) {
            System.out.println("Key: " + key + "; Value: " + currencyCountryMap.get(key));
        }
        System.out.println("\nMap size: " + currencyCountryMap.size());
    }

    /* If there is more than one country corresponding to the currency code, the value for the respective
    key (currency code) will be a String containing all the corresponding countries separated by semicolon and space*/
    private Map<String, String> makeCurrencyCountryMap(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Provided argument is null");
        } else if (!input.matches("([А-Я].*#[A-Z]{3}/)*([А-Я].*#[A-Z]{3})")) {
            throw new IllegalArgumentException("Input string does not match the supported pattern");
        } else {
            Map<String, String> resultingMap = new HashMap<>();
            Stream.of(input)
                    .map(s -> s.split("/"))
                    .flatMap(Arrays::stream)
                    .map(s -> s.split("#"))
                    .forEach(stringArray -> resultingMap.put(stringArray[1], stringArray[0]));
            return resultingMap;
        }
    }
}
