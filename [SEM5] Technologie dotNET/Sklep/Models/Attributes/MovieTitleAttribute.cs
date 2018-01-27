using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Sklep.Models.Attributes
{
    public class MovieTitleAttribute : ValidationAttribute
    {
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            string[] words = value.ToString().Split(' ');
            for(int i = 0; i < words.Length; i++)
            {
                if (!Char.IsUpper(words[i][0]))
                    return new ValidationResult("Every title word must start with capital letter.");
            }
            return ValidationResult.Success;
        }
    }
}