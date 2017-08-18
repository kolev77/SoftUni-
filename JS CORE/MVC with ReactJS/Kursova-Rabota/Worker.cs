using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kursova_Rabota
{
     class Worker
     {

         private static int id_serial = 0;
         private int id;

         public int ID
         {
             get { return id; }
         }

         private String egn;


         public string EGN
         {
            get { return egn; }
            set { egn = value; }
         }

        private String workerName;

        public string WorkerName
        {
            get { return workerName; }
            set { workerName = value; }
        }
        private String function;

        public string Function
        {
            get { return function; }
            set { function = value; }
        }
        private Int32 workingHours;

        public int WorkingHours
        {
            get { return workingHours; }
            set { workingHours = value; }
        }

         public Double pricePerHour;

         public double PricePerHour
         {
             get { return pricePerHour; }
             set { pricePerHour = value; }
         }
        private Double workingDays;

        public double WorkingDays
        {
            get { return workingDays; }
            set { workingDays = value; }
        }

       
        public double Payment
         {
             get { return workingHours * workingDays * pricePerHour; }
                          
         }

        //Конструктор на класа. На всички член-данни се присвояват стойности по подразбиране.
        //Този конструктор се използва от data grid-a, за да се създават нови редове директно чрез самия grid.
        public Worker()
        {
            //id за конкретния обект се попълва чрез брояча на обекти id_serial. 
            //Преди присвояване се прави преинкрементиране, т.е. броячът на обекти се увеличава с 1 ПРЕДИ стойноста му да бъде изпозлвана за id
            this.id = ++id_serial;
            this.EGN = "";
            this.WorkerName = "";
            this.Function = "";
            this.WorkingHours = 0;
            this.PricePerHour = 0;
            this.WorkingDays = 0;
        }

        public Worker(int id, String NewEGN, String NewWorkerName, String NewFunction, Int32 NewWorkingHours, Double NewPricePerHour, Double NewWorkingDays, Double payment)
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
            this.EGN = NewEGN;
            this.WorkerName = NewWorkerName;
            this.Function = NewFunction;
            this.WorkingHours = NewWorkingHours;
            this.PricePerHour = NewPricePerHour;
            this.WorkingDays = NewWorkingDays;

        }
        public override String ToString()
        {
            return id.ToString() +":" + EGN.ToString() + ":" + WorkerName.ToString() + ":" + Function.ToString()+":" + WorkingHours.ToString() +":"+ PricePerHour.ToString() +":" +  WorkingDays.ToString()+ ":" + Payment.ToString();
        }
    }
}


