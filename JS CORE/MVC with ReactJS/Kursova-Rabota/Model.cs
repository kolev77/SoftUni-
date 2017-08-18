using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kursova_Rabota;

namespace Kursova_Rabota
{
    static class Model
    {
       

        private static string WorkersFileName = @"../../../Kursova-Rabota/TextData/workers.txt";

        public static Dictionary<int, Worker> WorkersDictionary = new Dictionary<int, Worker>();

        public static void ReadData()
        {
            WorkersDictionary.Clear();

            String line;

            //Създава се обект за четене от файлът с данните
            System.IO.StreamReader file = new System.IO.StreamReader(WorkersFileName);
            //Чете се ред по ред до края на файла
            while ((line = file.ReadLine()) != null)
            {
                //Информацията за всеки ред се разделя по символа ':'. 
                //Като резултат се получава масив от низове с информацията нужна за създаване на обект от клас Provider.
                String[] data = line.Split(':');
                int id = Int32.Parse(data[0]);
                //Създава се обект от клас Worker и се попълва речникът с всички данни
                var payment = double.Parse(data[4])*double.Parse(data[5])*double.Parse(data[6]);
                WorkersDictionary.Add(id,
                    new Worker(id, data[1], data[2], data[3], int.Parse(data[4]), double.Parse(data[5]),
                        double.Parse(data[6]),payment));
            }
            //Файлът се затваря
            file.Close();
        }

        public static void StoreData()
        {
            StreamWriter sw = File.CreateText(WorkersFileName);
            foreach (Worker w in WorkersDictionary.Values)
            {
                sw.WriteLine(w.ToString());
            }
            sw.Close();
        }
        
        public static List<Worker> SortData(Boolean ByFunction, Boolean MostWorkingHours)
        {
            if (!ByFunction && !MostWorkingHours)
            {
                return null;
            }

            List<Worker> SortedData = new List<Worker>(WorkersDictionary.Values);

            if (ByFunction)
            {
                SortedData = SortedData.OrderBy(w => w.Function).ToList();
            }

            if (MostWorkingHours)
            {
                SortedData.OrderBy(x => x.WorkingHours);
              
            }

            return SortedData;

        }

        public static List<Worker> SearchWorker(String NamePart, String EgnPart)
        {
            List<Worker> FoundWorkers = new List<Worker>();

            foreach (var worker in WorkersDictionary.Keys)
            {
                if (!String.IsNullOrEmpty(NamePart) && !String.IsNullOrEmpty(EgnPart))
                {
                    if (WorkersDictionary[worker].WorkerName.Contains(NamePart) &&
                        WorkersDictionary[worker].EGN.Contains(EgnPart))
                    {
                        FoundWorkers.Add(WorkersDictionary[worker]);
                    }
                }
                //Проверка дали трябва да се търси само по име
                else if (!String.IsNullOrEmpty(NamePart))
                {
                    if (WorkersDictionary[worker].WorkerName.Contains(NamePart))
                    {
                        FoundWorkers.Add(WorkersDictionary[worker]);
                    }
                }
                else if (!String.IsNullOrEmpty(EgnPart))
                {
                    if (WorkersDictionary[worker].EGN.Contains(EgnPart))
                    {
                        FoundWorkers.Add(WorkersDictionary[worker]);
                    }
                }
                else
                {
                    return null;
                }
            }
            return FoundWorkers;
        }
    }
}

