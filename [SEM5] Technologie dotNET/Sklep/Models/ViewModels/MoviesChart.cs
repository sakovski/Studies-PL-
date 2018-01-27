using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Sklep.Models.ViewModels
{
    public class MoviesChart
    {
        public int Id { get; set; }
        private List<object[]> _data;
        public List<object[]> Data
        {
            get { return _data; }
            set { _data = value; }
        }

        public MoviesChart()
        {
            Data = new List<object[]>();
        }
    }
}