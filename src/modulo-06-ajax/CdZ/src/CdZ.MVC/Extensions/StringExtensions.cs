using System;
using System.Globalization;

namespace CdZ.MVC.Extensions
{
    public static class StringExtensions
    {
        public static DateTime FromISOToDateTime(this string isoDate)
        {
            if (isoDate == null)
                return DateTime.Today;
            var date = DateTime.Parse(isoDate, null, DateTimeStyles.RoundtripKind);
            return date;
        }
    }
} 