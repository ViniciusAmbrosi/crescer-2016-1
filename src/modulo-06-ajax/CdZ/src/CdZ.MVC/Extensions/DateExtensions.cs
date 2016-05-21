 using System;
using System.Globalization;

namespace CdZ.MVC.Extensions
{
    public static class DateTimeExtensions
    {

        public static string FromDateTimeToISOString(this DateTime date)
        {
            return date.ToString("s", CultureInfo.InvariantCulture);
        }
    }
} 