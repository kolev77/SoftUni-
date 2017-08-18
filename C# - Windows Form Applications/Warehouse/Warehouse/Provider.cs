using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Warehouse
{
    /*
     *Клас Provider съхранява информацията за един конкретен доставчик на продукти
     */
    class Provider
    {
        //id_serial - статична член-променлива. Използва се като брояч на обекти. При създаване на 
        //нов обект от клас Provider тази променлива се инкрементира. Чрез нея за всеки доставчик се осигурява уникален идентификатор
        private static int id_serial = 0;

        //id - уникален идентификатор на доставчик. Попълва се чрез член-променливата id_serial
        private int id;

        //getter за член променлива id
        public int ID
        {
            get { return id; }
            //няма нужда от setter, тъй като се попълва автоматично при създаване на обект и НЕ се променя от програмата
        }

        //name - име на доставчик
        private String name;

        //getter и setter за член-променлива name
        public String Name
        {
            get { return name; }
            set { name = value; }
        }

        //address - адрес на доставчик
        private String address;

        //getter и setter за член-променлива address
        public String Address
        {
            get { return address; }
            set { address = value; }
        }

        //phoneNumber - телефонен номер на доставчик
        private String phoneNumber;

        //getter и setter за член-променлива phoneNumber
        public String PhoneNumber
        {
            get { return phoneNumber; }
            set { phoneNumber = value; }
        }

        //Конструктор на класа. На всички член-данни се присвояват стойности по подразбиране.
        //Този конструктор се използва от data grid-a, за да се създават нови редове директно чрез самия grid.
        public Provider()
        {
            //id за конкретния обект се попълва чрез брояча на обекти id_serial. 
            //Преди присвояване се прави преинкрементиране, т.е. броячът на обекти се увеличава с 1 ПРЕДИ стойноста му да бъде изпозлвана за id
            this.id = ++id_serial;
            this.Name = "";
            this.Address = "";
            this.PhoneNumber = "";
        }

        //Параметричен конструктор. Този конструктор се използва при четене на данните от файла с всички доставчици и попълване на колекция с доставчици
        public Provider(int id, String NewName, String NewAddress, String NewPhoneNumber)
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
            this.Address = NewAddress;
            this.PhoneNumber = NewPhoneNumber;
        }

        //ToString метод. Преобразуване на съдържанието на обекта в низ. Използва при попълване на файлът с всички доставчици
        public override string ToString()
        {
            return id.ToString() + ":" + Name + ":" + Address + ":" + PhoneNumber;
        }
    }
}
