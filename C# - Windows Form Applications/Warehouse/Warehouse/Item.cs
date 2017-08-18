using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Warehouse
{
    /*
     *Клас Item съхранява информацията за един конкретен продукт от стоката, когято се съхранява в склада
     */
    class Item
    {
        //id_serial - статична член-променлива. Използва се като брояч на обекти. При създаване на 
        //нов обект от клас Item тази променлива се инкрементира. Чрез нея за всеки продукт се осигурява уникален идентификатор
        private static int id_serial=0;

        //id - уникален идентификатор на продукт. Попълва се чрез член-променливата id_serial
        private int id;

        //getter за член променлива id
        public int ID
        {
            get { return id; }
            //няма нужда от setter, тъй като се попълва автоматично при създаване на обект и НЕ се променя от програмата
        }

        //name - име на продукт
        private String name;
        
        //getter и setter за член-променлива name
        public String Name 
        {
            get { return name; }
            set { name = value; }
        }

        //price - цена на продукт
        private Double price;

        //getter и setter за член-променлива price
        public Double Price
        {
            get { return price; }
            set { price = value; }
        }

        //providerID - идентификатор на доставчик
        private int providerID;

        //getter и setter за член-променлива providerID. 
        //ВАЖНО: Това поле се изобразява и попълва чрез data grid. Методите са декларирани като String, тъй като чрез getter-a се връща по-пълна информация на потребителя.
        public String Provider
        {
            //Формата на връщания низ е <име на доставчик>(<id на доставчик>). 
            get { return Model.ProvidersDictionary[providerID].Name + "(" + providerID + ")"; }
            //От потребителя се очаква да предостави цяло число, което да се възприеме като id на доставчик. 
            //Тъй като входния параметър на setter-a също е String, e нужно да се направи преобразуване към цяло число
            set { providerID = Int32.Parse(value); }
        }

        //Конструктор на класа. На всички член-данни се присвояват стойности по подразбиране.
        //Този конструктор се използва от data grid-a, за да се създават нови редове директно чрез самия grid.
        public Item()
        {
            //id за конкретния обект се попълва чрез брояча на обекти id_serial. 
            //Преди присвояване се прави преинкрементиране, т.е. броячът на обекти се увеличава с 1 ПРЕДИ стойноста му да бъде изпозлвана за id
            this.id = ++id_serial;
            this.Name = "";
            this.Price = 0;
            this.providerID = 0;
        }

        //Параметричен конструктор. Този конструктор се използва при четене на данните от файла със стоката и попълване на колекция с продукти
        public Item(int id, String NewName, Double NewPrice, int NewProviderID)
        {
            this.id = id;
            //Тъй като информацията, която идва от файлът може да НЕ е подредена по id-та е нужно да се провери дали 
            //конкрентото id прочетено от файла е по-голямо от брояча на обекти id_serial. 
            //Ако прочетеното id e по-голямо, неговата стойност се присвоява и на id_serial. 
            //По този начин се осигурява, че при създаване на нов обект, той няма да има id, което вече да съществува, т.е. уникалност на id-тата
            if (id > id_serial)
            {
                id_serial = id;
            }
            this.Name = NewName;
            this.Price = NewPrice;
            this.providerID = NewProviderID;
        }
        
        //ToString метод. Преобразуване на съдържанието на обекта в низ. Използва при попълване на файлът с цялата стока
        public override String ToString()
        {
            return id.ToString() + ":" + Name + ":" + Price.ToString() + ":" + providerID.ToString();
        }
    }
}
