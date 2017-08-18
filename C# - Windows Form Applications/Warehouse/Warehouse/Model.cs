using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Warehouse
{
    /*
     * Клас Model реализира model частта на MVC архитектурата. Това е същинската логика на приложението:
     * - четене и запис на данните за стоки и доставчици от и във файловете;
     * - търсене на стоки и доставчици;
     * - сортиране на стоки и доставчици.
     * Този клас НЕ се занимава с изобразяването на информация на потребителския екран.
     * 
     * ВАЖНО: Класът модел е статичен клас. Всичките му член данни са статични и всичките му методи са статични.
     * Това означава, че от този клас НЕ СЕ СЪЗДАВАТ ОБЕКТИ. Методите на класа се викат директно чрез името на класа.
     * По този начин тези методи и данни са достъпни от цялата програма по всяко време без да е нужно навсякъде да съществува обект Model.
     */
    static class Model
    {
        //ItemsList - списък, в който се съхраняват всички продукти (обект Item)
        public static List<Item> ItemsList = new List<Item>();
        
        //ProvidersDictionary - речник, в който се съхраняват всички доставчици. Ключът е id на доставчик, а стойността е обект Provider
        public static Dictionary<int, Provider> ProvidersDictionary = new Dictionary<int, Provider>();

        //ItemsFilname - относистелен път до файл, в който се съхраняват всички продукти
        private static string ItemsFilname = @"Files/ItemsFile.txt";

        //ProviderFilname - относистелен път до файл, в който се съхраняват всички доставчици
        private static string ProviderFilname = @"Files/ProvidersFile.txt";

        //ReadData - метод за прочитане на цялата информация от двата файла и попълване на ItemsList и ProvidersDictionary
        public static void ReadData()
        {
            //Първо се изчиства съдържанието на колекциите
            ProvidersDictionary.Clear();
            ItemsList.Clear();
            String line;

            //Създава се обект за четене от файлът с всички доставчици - ProviderFilname
            System.IO.StreamReader file = new System.IO.StreamReader(ProviderFilname);
            //Чете се ред по ред до края на файла
            while ((line = file.ReadLine()) != null)
            {
                //Информацията за всеки ред се разделя по символа ':'. 
                //Като резултат се получава масив от низове с информацията нужна за създаване на обект от клас Provider.
                String[] data = line.Split(':');
                //id-то на обекта се преобразува в цяло число
                int id = Int32.Parse(data[0]);
                //Създава се обект от клас Provider и се попълва речникът с всички доставчици
                ProvidersDictionary.Add(id, new Provider(id, data[1], data[2], data[3]));
            }
            //Файлът се затваря
            file.Close();

            //Създава се нов обект - за чретене от файла с всички продукти - ItemsFilname
            file = new System.IO.StreamReader(ItemsFilname);
            //Чете се ред по ред до края на файла
            while ((line = file.ReadLine()) != null)
            {
                //Информацията за всеки ред се разделя по символа ':'. 
                //Като резултат се получава масив от низове с информацията нужна за създаване на обект от клас Item.
                String[] data = line.Split(':');
                //Създава се обект от клас Item и се попълва списъкът с всички продукти 
                //За създаването на обект Item е нужно някои от низовете да се преобразуват в число с плаваща запетая (Double) или цяло число
                ItemsList.Add(new Item(Int32.Parse(data[0]), data[1], Double.Parse(data[2]), Int32.Parse(data[3])));
            }
            //Файлът се затваря
            file.Close();
        }

        //StoreData - метод за съхранение на цялата информация от колекциите ProvidersDictionary и ItemsList във файловете с продукти и доставчици
        public static void StoreData()
        {
            //Създава се файл с доставчици. Ако вече съществува файл със същото име, той се замества
            StreamWriter sw = File.CreateText(ProviderFilname);
            //Обхождат се всички доставчици, записани в речника ProvidersDictionary
            foreach (Provider p in ProvidersDictionary.Values)
            {
                //Информацията за всеки доставчик се извлича чрез ToString() метода му и се запазва във файла
                sw.WriteLine(p.ToString());
            }
            //Файлът се затваря
            sw.Close();

            //Създава се файл с продукти. Ако вече съществува файл със същото име, той се замества
            sw = File.CreateText(ItemsFilname);
            //Обхождат се всички продукти, записани в списъка ItemsList
            foreach (Item i in ItemsList)
            {
                //Информацията за всеки продукт се извлича чрез ToString() метода му и се запазва във файла
                sw.WriteLine(i.ToString());
            }
            //Файлът се затваря
            sw.Close();
        }

        /*
         * SortItems - метод за сортиране на всички продукти по три различни критерия: име, цена и доставчик
         * Входни параметри:
         * - ByName - флаг, указващ да се извърши сортиране по име
         * - ByPrice - флаг, указващ да се извърши сортиране по цена
         * - ByProducer - флаг, указващ да се извърши сортиране по доставчик
         * Ако се подадат няколко критерия за сортиране, се извършва сортиране по всеки от подадените критерии.
         * Изходен параметър: списък с продукти, сортиран по указаните критерии
         */
        public static List<Item> SortItems(Boolean ByName, Boolean ByPrice, Boolean ByProducer)
        {
            //Ако не е получен нито един от входните параметру се връща null
            if (!ByName && !ByPrice && !ByProducer) { return null; }

            //Декларира се списък, който ще се сортира
            List<Item> SortedItems = new List<Item>(ItemsList);
            
            //Проверка дали да се сортира по доставчик
            if (ByProducer)
            {
                //Сортира се по доставчик. Резултатът от сортирането се присвоява на SortedItems
                SortedItems = SortedItems.OrderBy(s => s.Provider).ToList();
            }
            //Проверка дали да се сортира по цена
            if(ByPrice)
            {
                //Сортира се по цена. Резултатът от сортирането се присвоява на SortedItems
                SortedItems = SortedItems.OrderBy(s => s.Price).ToList();
            }
            //Проверка дали да се сортира по име
            if (ByName)
            {
                //Сортира се по име. Резултатът от сортирането се присвоява на SortedItems
                SortedItems = SortedItems.OrderBy(s => s.Name).ToList();
            }

            //Връща се списъкът, сортиран по избраните критерии
            return SortedItems;
        }

        /*
        * SortProviders - метод за сортиране на всички доставчици по два различни критерия: име и адрес
        * Входни параметри:
        * - ByName - флаг, указващ да се извърши сортиране по име
        * - ByAddress - флаг, указващ да се извърши сортиране по адрес
        * Ако се подадат няколко критерия за сортиране, се извършва сортиране по всеки от подадените критерии.
        * Изходен параметър: списък с доставчици, сортиран по указаните критерии
        */
        public static List<Provider> SortProviders(Boolean ByName, Boolean ByAddress)
        {
            //Ако не е получен нито един от входните параметру се връща null
            if (!ByName && !ByAddress) { return null; }

            //Декларира се списък, който ще се сортира
            List<Provider> SortedProviders = new List<Provider>(ProvidersDictionary.Values);

            //Проверка дали да се сортира по адрес
            if (ByAddress)
            {
                //Сортира се по адрес. Резултатът от сортирането се присвоява на SortedProviders
                SortedProviders = SortedProviders.OrderBy(s => s.Address).ToList();
                
            }
            //Проверка дали да се сортира по име
            if (ByName)
            {
                //Сортира се по име. Резултатът от сортирането се присвоява на SortedProviders
                SortedProviders = SortedProviders.OrderBy(s => s.Name).ToList();
            }

            //Връща се списъкът, сортиран по избраните критерии
            return SortedProviders;
        }

        /*
         * SearchItems - метод за търсене на множество продукти, отговарящи на дадени условия
         * Входни параметри:
         * - NamePart - низ. Част от име на продукт, която да се съдържа в цялото име на продукта
         * - ProviderPart - низ. Част от име на доставчик, която да се съдържа в цялото име на доставчика на продукта
         * Ако се подадат повече от едно условие, се извършва търсене по всички подадени условия.
         * Изходен параметър: Списък от продуктите, отговарящи на подадените условия
         */
        public static List<Item> SearchItems(String NamePart, String ProviderPart)
        {
            //Декларира се списък, в който да се попълват откритете продукти
            List <Item> FoundItems = new List<Item>();

            //Обхождат се всички продукти, записани в списъка ItemsList
            foreach (Item i in ItemsList)
            {
                //Проверка дали трябва да се търси и по име и по доставчик
                if (!String.IsNullOrEmpty(NamePart) && !String.IsNullOrEmpty(ProviderPart))
                {
                    //Ако името на текущия, обхождан продукт съдържа получената част от име на продукт И
                    //името на доставчика на текущия, обхождан продукт съдържа получената част от име на доставчик,
                    //то е открит продукт, отговарящ на получените условия. Продуктът се добавя в списъка FoundItems
                    if (i.Name.Contains(NamePart) && i.Provider.Contains(ProviderPart))
                    {
                        FoundItems.Add(i);
                    }
                }
                //Проверка дали трябва да се търси само по име
                else if(!String.IsNullOrEmpty(NamePart))
                {
                    //Ако името на текущия, обхождан продукт съдържа получената част от име на продукт
                    //то е открит продукт, отговарящ на получените условия. Продуктът се добавя в списъка FoundItems
                    if (i.Name.Contains(NamePart))
                    {
                        FoundItems.Add(i);
                    }
                }
                //Проверка дали трябва да се търси само по доставчик
                else if(!String.IsNullOrEmpty(ProviderPart))
                {
                    //Ако името на доставчика на текущия, обхождан продукт съдържа получената част от име на доставчик,
                    //то е открит продукт, отговарящ на получените условия. Продуктът се добавя в списъка FoundItems
                    if (i.Provider.Contains(ProviderPart))
                    {
                        FoundItems.Add(i);
                    }
                }
                //Не е получено нито едно условие, по което да се търси. Метода връща null.
                else
                {
                    return null;
                }
                   
            }

            //Връщат се откритите продукти
            return FoundItems;
        }

        /*
        * SearchProviders - метод за търсене на множество доставчици, отговарящи на дадени условия
        * Входни параметри:
        * - NamePart - низ. Част от име на доставчик, която да се съдържа в цялото име на доставчика
        * - PhoneNoPart - низ. Част от телефонен номер на доставчик, която да се съдържа в цялия тел. номер на доставчика 
        * Ако се подадат повече от едно условие, се извършва търсене по всички подадени условия.
        * Изходен параметър: Списък от доставчиците, отговарящи на подадените условия
        */
        public static List<Provider> SearchProviders(String NamePart, String PhoneNoPart)
        {
            //Декларира се списък, в който да се попълват откритете доставчици
            List<Provider> FoundProviders = new List<Provider>();

            //Обхождат се всички доставчици, записани в речника ProvidersDictionary
            foreach (Provider p in ProvidersDictionary.Values)
            {
                //Проверка дали трябва да се търси и по име и по телефон
                if (!String.IsNullOrEmpty(NamePart) && !String.IsNullOrEmpty(PhoneNoPart))
                {
                    //Ако името на текущия, обхождан доставчик съдържа получената част от име на доставчик И
                    //телелефонът на текущия, обхождан доставчик съдържа получената част от телефон на доставчик,
                    //то е открит доставчик, отговарящ на получените условия. Доставчикът се добавя в списъка FoundProviders
                    if (p.Name.Contains(NamePart) && p.PhoneNumber.Contains(PhoneNoPart))
                    {
                        FoundProviders.Add(p);
                    }
                }
                //Проверка дали трябва да се търси само по име 
                else if (!String.IsNullOrEmpty(NamePart))
                {
                    //Ако името на текущия, обхождан доставчик съдържа получената част от име на доставчик,
                    //то е открит доставчик, отговарящ на получените условия. Доставчикът се добавя в списъка FoundProviders
                    if (p.Name.Contains(NamePart))
                    {
                        FoundProviders.Add(p);
                    }
                }
                //Проверка дали трябва да се търси само по телефон
                else if (!String.IsNullOrEmpty(PhoneNoPart))
                {
                    //Ако телелефонът на текущия, обхождан доставчик съдържа получената част от телефон на доставчик,
                    //то е открит доставчик, отговарящ на получените условия. Доставчикът се добавя в списъка FoundProviders
                    if (p.PhoneNumber.Contains(PhoneNoPart))
                    {
                        FoundProviders.Add(p);
                    }
                }
                //Не е получено нито едно условие, по което да се търси. Метода връща null.
                else
                {
                    return null;
                }

            }
            //Връщат се откритите доставчици
            return FoundProviders;
        }
    }
}
