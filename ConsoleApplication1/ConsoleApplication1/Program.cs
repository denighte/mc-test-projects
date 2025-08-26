using System;
using iText.Commons.Utils;

namespace ConsoleApplication1
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write(JsonUtil.SerializeToMinimalString("abc abc"));
        }
    }
}