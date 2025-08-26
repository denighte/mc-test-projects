using iText.Commons.Utils;
using System;

namespace SampleApp
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write(JsonUtil.SerializeToString("abc abc"));
        }
    }
}