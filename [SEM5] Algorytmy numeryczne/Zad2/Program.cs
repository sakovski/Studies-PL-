using System;
using System.Globalization;
using System.IO;
using System.Numerics;
using System.Threading;

namespace MatrixExercise
{
    public static class Helpers
    {
        public static BigInteger abs(BigInteger a)
        {
            if(a < BigInteger.Zero)
            {
                a = -a;
            }
            return a;
        }

        public static BigInteger gcd(BigInteger a, BigInteger b)
        {
            a = Helpers.abs(a);
            b = Helpers.abs(b);
            while (a != b)
            {
                if (a > b)
                    a -= b;
                else
                    b -= a;
            }
            return a;
        }

        public static BigInteger lcm(BigInteger a, BigInteger b)
        {
            return (a * b) / gcd(a, b);
        }

        public static T abs<T>(T a)
        {
            if ((dynamic)a < 0)
                return (dynamic)a * (-1);
            return a;
        }
    }

    public struct Fraction
    {
        public BigInteger Numerator { get; set; }
        public BigInteger Denominator { get; set; }

        public Fraction(BigInteger numerator, BigInteger denominator)
        {
            

            if (denominator == 0 || numerator == 0)
            {
                Denominator = 0;
                Numerator = 0;
            }
            else
            {
                Denominator = denominator;
                Numerator = numerator;
                shorten();
            }
        }

        private void shorten()
        {
            if(Denominator != 0 && Numerator != 0)
            {
                BigInteger gcd = Helpers.gcd(Numerator, Denominator);
                if (gcd != BigInteger.One)
                {
                    Numerator = Numerator / gcd;
                    Denominator = Denominator / gcd;
                }
            }         
        }

        public override string ToString()
        {
            shorten();
            return String.Format("{0}/{1}", Numerator, Denominator);
        }

        public void printValue()
        {
            shorten();
            Console.WriteLine(Numerator / Denominator);
        }

        public static Fraction operator +(Fraction x, Fraction y)
        {
            x.shorten();
            y.shorten();
            if (x.Denominator == y.Denominator)
            {
                return new Fraction(x.Numerator + y.Numerator, x.Denominator);
            }
            else
            {
                if (x.Denominator != 0 && y.Denominator != 0)
                {
                    BigInteger commonDenominator = Helpers.lcm(x.Denominator, y.Denominator);
                    return new Fraction((commonDenominator / x.Denominator) * x.Numerator + (commonDenominator / y.Denominator) * y.Numerator, commonDenominator);
                }
                else if (x.Denominator == 0)
                {
                    return y;
                }
                    return x;               
            }
        }

        public static Fraction operator -(Fraction x, Fraction y)
        {
            x.shorten();
            y.shorten();
            if (x.Denominator == y.Denominator)
            {
                return new Fraction(x.Numerator - y.Numerator, x.Denominator);
            }
            else
            {
                if (x.Denominator != 0 && y.Denominator != 0)
                {
                    BigInteger commonDenominator = Helpers.lcm(x.Denominator, y.Denominator);
                    return new Fraction((commonDenominator / x.Denominator) * x.Numerator - (commonDenominator / y.Denominator) * y.Numerator, commonDenominator);
                }
                else if (x.Denominator == 0)
                {
                    return y;
                }
                return x;
            }
        }

        public static Fraction operator *(Fraction x, Fraction y)
        {
            x.shorten();
            y.shorten();
            return new Fraction(x.Numerator * y.Numerator, x.Denominator * y.Denominator);
        }

        public static Fraction operator *(Fraction x, BigInteger y)
        {
            x.shorten();
            return new Fraction(x.Numerator * y, x.Denominator);
        }

        public static Fraction operator /(Fraction x, Fraction y)
        {
            x.shorten();
            y.shorten();
            return new Fraction(x.Numerator * y.Denominator, x.Denominator * y.Numerator);
        }

        public static Fraction operator /(Fraction x, BigInteger y)
        {
            x.shorten();
            return new Fraction(x.Numerator, x.Denominator * y);
        }

        public static bool operator ==(Fraction x, Fraction y)
        {
            x.shorten();
            y.shorten();
            return ((x.Numerator / x.Denominator) == (y.Numerator / y.Denominator));
        }

        public static bool operator ==(Fraction x, BigInteger a)
        {
            x.shorten();
            return ((x.Numerator / x.Denominator) == a);
        }

        public static bool operator !=(Fraction x, Fraction y)
        {
            x.shorten();
            y.shorten();
            return (x.Numerator / x.Denominator != y.Numerator / y.Denominator);
        }

        public static bool operator !=(Fraction x, BigInteger a)
        {
            x.shorten();
            return (x.Numerator / x.Denominator != a);
        }

        public static bool operator <(Fraction x, Fraction y)
        {
            x.shorten();
            y.shorten();
            return (x.Numerator / x.Denominator < y.Numerator / y.Denominator);
        }

        public static bool operator <(Fraction x, BigInteger a)
        {
            x.shorten();
            return (x.Numerator / x.Denominator < a);
        }      

        public static bool operator >(Fraction x, Fraction y)
        {
            x.shorten();
            y.shorten();
            return (x.Numerator / x.Denominator > y.Numerator / y.Denominator);
        }

        public static bool operator >(Fraction x, BigInteger y)
        {
            x.shorten();
            return (x.Numerator / x.Denominator > y);
        }

        public static bool operator <=(Fraction x, Fraction y)
        {
            x.shorten();
            y.shorten();
            return (x.Numerator / x.Denominator <= y.Numerator / y.Denominator);
        }

        public static bool operator <=(Fraction x, BigInteger y)
        {
            x.shorten();
            return (x.Numerator / x.Denominator <= y);
        }

        public static bool operator >=(Fraction x, Fraction y)
        {
            x.shorten();
            y.shorten();
            return (x.Numerator / x.Denominator >= y.Numerator / y.Denominator);
        }

        public static bool operator >=(Fraction x, BigInteger y)
        {
            x.shorten();
            return (x.Numerator / x.Denominator <= y);
        }
    }

    public class MyMatrix<T> where T : struct
    {       
        private int _rows;
        private int _columns;
        public T[,] Matrix { get;  set; }
        public T[] VectorB { get;  set; }
        public T[] VectorX { get;  set; }
        Type typeParameterT = typeof(T);
        Type typeParameterDouble = typeof(Double);
        Type typeParameterFloat = typeof(float);
        Type typeParameterFraction = typeof(Fraction);

        public MyMatrix(int rows, int columns)
        {
            _rows = rows;
            _columns = columns;
            Matrix = new T[_rows, _columns];
            VectorB = new T[_rows];
            VectorX = new T[_rows];
        }

        public T this[int i, int j]
        {
            get
            {
                if (i < _rows && j < _columns)
                    return Matrix[i, j];
                else
                    throw new ArgumentOutOfRangeException();
            }
            set
            {
                if (i < _rows && j < _columns)
                    Matrix[i, j] = value;
                else
                    throw new ArgumentOutOfRangeException();
            }
        }

        public void fillMatrixAndVectorBWithRandomValues()
        {

            Random random = new Random();

            if (typeParameterT == typeParameterDouble)
            {
                for (int i = 0; i < _rows; ++i)
                {
                    for (int j = 0; j < _columns; ++j)
                        Matrix[i, j] = (dynamic)random.NextDouble() + random.Next(1000);
                    VectorB[i] = (dynamic)random.NextDouble() + random.Next(1000);
                }
            }
            else if (typeParameterT == typeParameterFloat)
            {
                float tmp;
                for (int i = 0; i < _rows; ++i)
                {
                    for (int j = 0; j < _columns; ++j)
                    {
                        tmp = (float)random.NextDouble() + random.Next(1000);
                        Matrix[i, j] = (dynamic)tmp;
                    }
                    tmp = (float)random.NextDouble() + random.Next(1000);
                    VectorB[i] = (dynamic)tmp;
                }
            }
            else if (typeParameterT == typeParameterFraction)
            {
                for (int i = 0; i < _rows; ++i)
                {
                    for (int j = 0; j < _columns; ++j)
                    {
                        Matrix[i, j] = (dynamic)new Fraction(random.Next(1, 10), random.Next(1, 10));
                    }
                    VectorB[i] = (dynamic)new Fraction(random.Next(1, 10), random.Next(1, 10));
                }
            }
            else
            {
                for (int i = 0; i < _rows; ++i)
                {
                    for (int j = 0; j < _columns; ++j)
                    {
                        Matrix[i, j] = (dynamic)0;
                    }
                    VectorB[i] = (dynamic)0;
                }
            }
        }

        public void printMatrix()
        {
            for (int i = 0; i < _rows; i++)
            {
                for (int j = 0; j < _columns; j++)
                {
                    Console.Write(string.Format("{0} ", Matrix[i, j]));
                }
                Console.Write(Environment.NewLine + Environment.NewLine);
            }
        }

        public void printMatrixAndVectorB()
        {
            for (int i = 0; i < _rows; i++)
            {
                for (int j = 0; j < _columns; j++)
                {
                    Console.Write(string.Format("{0} ", Matrix[i, j]));
                }
                Console.Write(string.Format("| {0} ", VectorB[i]));
                Console.Write(Environment.NewLine + Environment.NewLine);
            }
        }

        public void printVectorX()
        {
            for(int i = 0; i<_rows; i++)
            {
                Console.WriteLine(VectorX[i]);
            }
        }

        public void printVectorB()
        {
            for (int i = 0; i < _rows; i++)
            {
                Console.WriteLine(VectorB[i]);
            }
        }

        public bool gaussianEliminationWithoutPivoting()
        {
            T m, s;
            int n = _rows;

            //Filling AB matrix
            T[,] AB = (dynamic)createABMatrix();
            // Step1
            for (int i = 0; i < n; i++)
            {
                for (int j = i + 1; j < n; j++)
                {
                    if (Helpers.abs<T>((dynamic)Matrix[i,i]) == (dynamic)0)
                        return false;
                    m = (dynamic)AB[j,i] * (-1) / AB[i,i];
                    for (int k = i + 1; k <= n; k++)
                        AB[j,k] = (dynamic)AB[j,k] + m * (dynamic)AB[i,k];
                }
            }

            // Step2 
            for (int i = n - 1; i >= 0; i--)
            {
                s = (dynamic)AB[i,n];
                for (int j = n - 1; j >= i + 1; j--)
                    s -= (dynamic)AB[i,j] * VectorX[j];
                if (Helpers.abs<T>((dynamic)AB[i,i]) == (dynamic)0)
                    return false;
                VectorX[i] = s / (dynamic)AB[i,i];
            }
            return true;
        }

        public bool gaussianEliminationPartialPivoting()
        {
            T m, s, max;
            int n = _rows;
            int maxRow;
            //Filling AB matrix
            T[,] AB = (dynamic)createABMatrix();

            // Step1
            for (int i = 0; i < n; i++)
            {
                max = AB[i, i];
                maxRow = i;
                for (int j = i + 1; j < n; j++) //finding max in column
                {
                    if ((dynamic)max < AB[j, i])
                    {
                        max = AB[j, i];
                        maxRow = j;
                    }                       
                                   
                }
                if (maxRow != i) //swap rows if needed
                {                   
                    T[] tmp = new T[n+1];
                    for (int k = 0; k <= n; k++)
                    {
                        tmp[k] = AB[maxRow, k];
                        AB[maxRow, k] = AB[i, k];
                        AB[i,k] = tmp[k];
                    }
                }
                for (int j = i + 1; j < n; j++) 
                {
                    m = -((dynamic)AB[j, i]) / AB[i, i];
                    for (int k = i + 1; k <= n; k++)
                        AB[j, k] = (dynamic)AB[j, k] + m * (dynamic)AB[i, k];
                }
                
            }

            // Step2 
            for (int i = n - 1; i >= 0; i--)
            {
                s = (dynamic)AB[i, n];
                for (int j = n - 1; j >= i + 1; j--)
                    s -= (dynamic)AB[i, j] * VectorX[j];
                if (Math.Abs((dynamic)AB[i, i]) == 0)
                    return false;
                VectorX[i] = s / (dynamic)AB[i, i];
            }
            return true;
        }

        public bool gaussianEliminationCompletePivoting()
        {
            T m, s, max;
            int n = _rows;
            int maxRow, maxColumn;
            //Filling AB matrix
            T[,] AB = (dynamic)createABMatrix();

            // Step1
            for (int i = 0; i < n; i++)
            {
                max = AB[i, i];
                maxRow = i;
                maxColumn = i;
                for (int j = i + 1; j < n; j++) //finding max in subMatrix
                {
                    for(int k = i + 1; k < n; k++)
                    {
                        if ((dynamic)max < AB[k, j])
                        {
                            max = AB[k, j];
                            maxRow = k;
                            maxColumn = j;
                        }
                    }
                    

                }
                if (maxRow != i) //swap rows if needed
                {
                    T[] tmp = new T[n + 1];
                    for (int k = 0; k <= n; k++)
                    {
                        tmp[k] = AB[maxRow, k];
                        AB[maxRow, k] = AB[i, k];
                        AB[i, k] = tmp[k];
                    }
                }
                if(maxColumn != i) //swap columns if needed
                {
                    T[] tmp = new T[n];
                    for (int k = 0; k < n; k++)
                    {
                        tmp[k] = AB[k, maxColumn];
                        AB[k, maxColumn] = AB[k,i];
                        AB[k,i] = tmp[k]; //WE NEED TO NOTE COLUMN SWITCH TO SWITCH VECTORS
                    }
                }

                for (int j = i + 1; j < n; j++)
                {
                    m = -((dynamic)AB[j, i]) / AB[i, i];
                    for (int k = i + 1; k <= n; k++)
                        AB[j, k] = (dynamic)AB[j, k] + m * (dynamic)AB[i, k];
                }

            }

            // Step2 
            for (int i = n - 1; i >= 0; i--)
            {
                s = (dynamic)AB[i, n];
                for (int j = n - 1; j >= i + 1; j--)
                    s -= (dynamic)AB[i, j] * VectorX[j];
                if (Math.Abs((dynamic)AB[i, i]) == 0)
                    return false;
                VectorX[i] = s / (dynamic)AB[i, i];
            }
            return true;
        }

        private T[,] createABMatrix()
        {
            T[,] AB = new T[_rows, _columns + 1];
            for (int i = 0; i < _rows; i++)
            {
                for (int j = 0; j <= _rows; j++)
                {
                    if (j == _rows)
                        AB[i, j] = (dynamic)VectorB[i];
                    else
                        AB[i, j] = (dynamic)Matrix[i, j];
                }
            }
            return AB;
        }       

        public static MyMatrix<T> operator +(MyMatrix<T> x, MyMatrix<T> y)
        {
            if (x._rows == y._rows && x._columns == y._columns)
            {
                MyMatrix<T> result = new MyMatrix<T>(x._rows, x._columns);
                for (int i = 0; i < result._rows; ++i)
                {
                    for (int j = 0; j < result._columns; ++j)
                        result[i, j] = (dynamic)x[i, j] + y[i, j];
                }
                return result;
            }
            else
            {
                throw new ArgumentException("Matrixes don`t match operator+ requirements!");
            }
            
        }

        public static MyMatrix<T> operator *(MyMatrix<T> x, MyMatrix<T> y)
        {
            if (x._columns == y._rows)
            {
                MyMatrix<T> result = new MyMatrix<T>(x._columns, y._rows);
                for (int i = 0; i < y._rows; i++)
                {
                    for (int j = 0; j < y._columns; j++)
                    {
                        for (int k = 0; k < y._rows; k++)
                        {
                            result[i, j] += (dynamic)x[i, k] * y[k,j];
                        }
                    }
                }
                return result;
            }
            else
            {
                throw new ArgumentException("Matrixes don`t match operator* requirements!");
            }
        }

        public static T[] operator *(MyMatrix<T> x, T[] y)
        {
            if (x._columns == y.Length)
            {
                T[] result = new T[x._rows];
                for (int i = 0; i < x._rows; i++)
                {
                    for (int j = 0; j < x._columns; j++)
                    {
                        result[i] = result[i] + (dynamic)x[i, j] * y[j];
                    }
                }
                return result;
            }
            else
            {
                throw new ArgumentException("Matrix and vector don`t match operator* requirements!");
            }
        }
    }

    class Program
    {
        static void Main(string[] args)
        {

            using (TextReader tw = File.OpenText("daneFloat.txt"))
            {
                TextWriter czasyFloatWriter = new StreamWriter("czasyMojeFloat.csv");

                for (int i = 2; i <= 29; i++)
                {
                    int size = Int32.Parse(tw.ReadLine());

                    MyMatrix<float> matrixA = new MyMatrix<float>(size, size);
                    for (int j = 0; j < size; j++)
                    {
                        string row = tw.ReadLine();
                        string[] values = row.Split(null);
                        for (int k = 0; k < size; k++)
                        {
                            matrixA[j, k] = float.Parse(values[k], CultureInfo.InvariantCulture);
                        }
                    }
                    tw.ReadLine();

                    MyMatrix<float> matrixB = new MyMatrix<float>(size, size);
                    for (int j = 0; j < size; j++)
                    {
                        string row = tw.ReadLine();
                        string[] values = row.Split(null);
                        for (int k = 0; k < size; k++)
                        {
                            matrixB[j, k] = float.Parse(values[k], CultureInfo.InvariantCulture);
                        }
                    }
                    tw.ReadLine();

                    MyMatrix<float> matrixC = new MyMatrix<float>(size, size);
                    for (int j = 0; j < size; j++)
                    {
                        string row = tw.ReadLine();
                        string[] values = row.Split(null);
                        for (int k = 0; k < size; k++)
                        {
                            matrixC[j, k] = float.Parse(values[k], CultureInfo.InvariantCulture);
                        }
                    }
                    tw.ReadLine();

                    float[] VectorB = new float[size];
                    string vecB = tw.ReadLine();
                    string vecX = tw.ReadLine();
                    string[] valuesB = vecB.Split(null);
                    for (int k = 0; k < size; k++)
                    {
                        matrixA.VectorB[k] = float.Parse(valuesB[k], CultureInfo.InvariantCulture);
                    }

                    performFirstOperationOnFloat(matrixA, czasyFloatWriter);
                    performSecondOperationOnFloat(matrixA, matrixB, matrixC, czasyFloatWriter);
                    performThirdOperationOnFloat(matrixA, matrixB, matrixC, czasyFloatWriter);
                    performGaussianpivotingOnFloat(matrixA, czasyFloatWriter);
                    performGaussianPartialpivotingOnFloat(matrixA, czasyFloatWriter);
                    performGaussianFullpivotingOnFloat(matrixA, czasyFloatWriter);
                    czasyFloatWriter.Write("\r\n");
                }
                czasyFloatWriter.Close();
            }

            using (TextReader tw = File.OpenText("daneDouble.txt"))
            {
                TextWriter czasyDoubleWriter = new StreamWriter("czasyMojeDouble.csv");

                for (int i = 2; i <= 29; i++)
                {
                    int size = int.Parse(tw.ReadLine());

                    MyMatrix<double> matrixA = new MyMatrix<double>(size, size);
                    for (int j = 0; j < size; j++)
                    {
                        string row = tw.ReadLine();
                        string[] values = row.Split(null);
                        for (int k = 0; k < size; k++)
                        {
                            matrixA[j, k] = Double.Parse(values[k], CultureInfo.InvariantCulture);
                        }
                    }
                    tw.ReadLine();

                    MyMatrix<double> matrixB = new MyMatrix<double>(size, size);
                    for (int j = 0; j < size; j++)
                    {
                        string row = tw.ReadLine();
                        string[] values = row.Split(null);
                        for (int k = 0; k < size; k++)
                        {
                            matrixB[j, k] = Double.Parse(values[k], CultureInfo.InvariantCulture);
                        }
                    }
                    tw.ReadLine();

                    MyMatrix<double> matrixC = new MyMatrix<double>(size, size);
                    for (int j = 0; j < size; j++)
                    {
                        string row = tw.ReadLine();
                        string[] values = row.Split(null);
                        for (int k = 0; k < size; k++)
                        {
                            matrixC[j, k] = Double.Parse(values[k], CultureInfo.InvariantCulture);
                        }
                    }
                    tw.ReadLine();

                    double[] VectorB = new double[size];
                    string vecB = tw.ReadLine();
                    string vecX = tw.ReadLine();
                    string[] valuesB = vecB.Split(null);
                    for (int k = 0; k < size; k++)
                    {
                        matrixA.VectorB[k] = Double.Parse(valuesB[k], CultureInfo.InvariantCulture);
                    }


                    performFirstOperationOnDouble(matrixA, czasyDoubleWriter);
                    performSecondOperationOnDouble(matrixA, matrixB, matrixC, czasyDoubleWriter);
                    performThirdOperationOnDouble(matrixA, matrixB, matrixC, czasyDoubleWriter);
                    performGaussianpivotingOnDouble(matrixA, czasyDoubleWriter);
                    performGaussianPartialpivotingOnDouble(matrixA, czasyDoubleWriter);
                    performGaussianFullpivotingOnDouble(matrixA, czasyDoubleWriter);
                    czasyDoubleWriter.Write("\r\n");
                }
                czasyDoubleWriter.Close();
            }

            using (TextReader tw = File.OpenText("daneFraction.txt"))
            {
                TextWriter czasyFractionWriter = new StreamWriter("czasyMojeFraction.csv");

                for (int i = 2; i <= 29; i++)
                {
                    int size = Int32.Parse(tw.ReadLine());

                    MyMatrix<Fraction> matrixA = new MyMatrix<Fraction>(size, size);
                    for (int j = 0; j < size; j++)
                    {
                        string row = tw.ReadLine();
                        string[] values = row.Split(null);
                        for (int k = 0; k < size; k++)
                        {
                            string[] fraction = values[k].Split('/');
                            matrixA[j, k] = new Fraction(int.Parse(fraction[0]), int.Parse(fraction[1]));
                        }
                    }
                    tw.ReadLine();

                    MyMatrix<Fraction> matrixB = new MyMatrix<Fraction>(size, size);
                    for (int j = 0; j < size; j++)
                    {
                        string row = tw.ReadLine();
                        string[] values = row.Split(null);
                        for (int k = 0; k < size; k++)
                        {
                            string[] fraction = values[k].Split('/');
                            matrixB[j, k] = new Fraction(int.Parse(fraction[0]), int.Parse(fraction[1]));
                        }
                    }
                    tw.ReadLine();

                    MyMatrix<Fraction> matrixC = new MyMatrix<Fraction>(size, size);
                    for (int j = 0; j < size; j++)
                    {
                        string row = tw.ReadLine();
                        string[] values = row.Split(null);
                        for (int k = 0; k < size; k++)
                        {
                            string[] fraction = values[k].Split('/');
                            matrixC[j, k] = new Fraction(int.Parse(fraction[0]), int.Parse(fraction[1]));
                        }
                    }
                    tw.ReadLine();

                    double[] VectorB = new double[size];
                    string vecB = tw.ReadLine();
                    string vecX = tw.ReadLine();
                    string[] valuesB = vecB.Split(null);
                    for (int k = 0; k < size; k++)
                    {
                        string[] fraction = valuesB[k].Split('/');
                        matrixA.VectorB[k] = new Fraction(int.Parse(fraction[0]), int.Parse(fraction[1]));
                    }

                    performFirstOperationOnMyFraction(matrixA, czasyFractionWriter);
                    performSecondOperationOnMyFraction(matrixA, matrixB, matrixC, czasyFractionWriter);
                    performThirdOperationOnMyFraction(matrixA, matrixB, matrixC, czasyFractionWriter);
                    performGaussianpivotingOnFraction(matrixA, czasyFractionWriter);
                    performGaussianPartialpivotingOnFraction(matrixA, czasyFractionWriter);
                    performGaussianFullpivotingOnFraction(matrixA, czasyFractionWriter);
                    czasyFractionWriter.Write("\r\n");
                }
                czasyFractionWriter.Close();
            }


            Console.WriteLine("TESTS FINISHED");
            Console.ReadKey();
        }


        //------------EXERCISE 1------------------------------
        //A * X
        private static void performFirstOperationOnFloat(MyMatrix<float> matrix, TextWriter timeWriter)
        {
            matrix.printMatrix();
            Console.WriteLine("***************");
            matrix.printVectorB();
            Console.WriteLine("==============");
            float[] vector;          
            var watch = System.Diagnostics.Stopwatch.StartNew();
            vector = matrix * matrix.VectorB;
            watch.Stop();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;

            foreach (float element in vector)
            {
                Console.WriteLine(element);
            }
            Console.WriteLine(elapsedMs);

            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performFirstOperationOnDouble(MyMatrix<double> matrix, TextWriter timeWriter)
        {
            matrix.printMatrix();
            Console.WriteLine("***************");
            matrix.printVectorB();
            Console.WriteLine("==============");
            double[] vector;
            var watch = System.Diagnostics.Stopwatch.StartNew();
            vector = matrix * matrix.VectorB;
            watch.Stop();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;

            foreach (double element in vector)
            {
                Console.WriteLine(element);
            }
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performFirstOperationOnMyFraction(MyMatrix<Fraction> matrix, TextWriter timeWriter)
        {
            matrix.printMatrix();
            Console.WriteLine("***************");
            matrix.printVectorB();
            Console.WriteLine("==============");
            Fraction[] vector;
            var watch = System.Diagnostics.Stopwatch.StartNew();
            vector = matrix * matrix.VectorB;
            watch.Stop();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;

            foreach (Fraction element in vector)
            {
                Console.WriteLine(element);
            }
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        //(A + B + C) * X
        private static void performSecondOperationOnFloat(MyMatrix<float> matrixA, MyMatrix<float> matrixB, MyMatrix<float> matrixC, TextWriter timeWriter)
        {
            matrixA.printMatrix();
            Console.WriteLine("+++++++++++++");
            matrixB.printMatrix();
            Console.WriteLine("+++++++++++++");
            matrixC.printMatrix();
            Console.WriteLine("************");
            matrixA.printVectorB();
            Console.WriteLine("==============");
            var watch = System.Diagnostics.Stopwatch.StartNew();
            MyMatrix<float> matrixTemp = matrixA + matrixB;
            matrixTemp = matrixTemp + matrixC;
            float[] vector = matrixTemp * matrixA.VectorB;
            watch.Stop();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            foreach (float element in vector)
            {
                Console.WriteLine(element);
            }
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performSecondOperationOnDouble(MyMatrix<double> matrixA, MyMatrix<double> matrixB, MyMatrix<double> matrixC, TextWriter timeWriter)
        {
            matrixA.printMatrix();
            Console.WriteLine("+++++++++++++");
            matrixB.printMatrix();
            Console.WriteLine("+++++++++++++");
            matrixC.printMatrix();
            Console.WriteLine("************");
            matrixA.printVectorB();
            Console.WriteLine("==============");
            var watch = System.Diagnostics.Stopwatch.StartNew();
            MyMatrix<double> matrixTemp = matrixA + matrixB;
            matrixTemp = matrixTemp + matrixC;
            double[] vector = matrixTemp * matrixA.VectorB;
            watch.Stop();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            foreach (double element in vector)
            {
                Console.WriteLine(element);
            }
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performSecondOperationOnMyFraction(MyMatrix<Fraction> matrixA, MyMatrix<Fraction> matrixB, MyMatrix<Fraction> matrixC, TextWriter timeWriter)
        {
            matrixA.printMatrix();
            Console.WriteLine("+++++++++++++");
            matrixB.printMatrix();
            Console.WriteLine("+++++++++++++");
            matrixC.printMatrix();
            Console.WriteLine("************");
            matrixA.printVectorB();
            Console.WriteLine("==============");
            var watch = System.Diagnostics.Stopwatch.StartNew();
            MyMatrix<Fraction> matrixTemp = matrixA + matrixB;
            matrixTemp = matrixTemp + matrixC;
            Fraction[] vector = matrixTemp * matrixA.VectorB;
            watch.Stop();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            foreach (Fraction element in vector)
            {
                Console.WriteLine(element);
            }
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        //A * (B * C)
        private static void performThirdOperationOnFloat(MyMatrix<float> matrixA, MyMatrix<float> matrixB, MyMatrix<float> matrixC, TextWriter timeWriter)
        {
            matrixA.printMatrix();
            Console.WriteLine("*************");
            matrixB.printMatrix();
            Console.WriteLine("**************");
            matrixC.printMatrix();
            Console.WriteLine("==============");
            var watch = System.Diagnostics.Stopwatch.StartNew();
            MyMatrix<float> matrixTemp = matrixB * matrixC;
            matrixTemp = matrixA * matrixTemp;
            watch.Stop();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            matrixTemp.printMatrix();
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");

        }

        private static void performThirdOperationOnDouble(MyMatrix<double> matrixA, MyMatrix<double> matrixB, MyMatrix<double> matrixC, TextWriter timeWriter)
        {
            matrixA.printMatrix();
            Console.WriteLine("*************");
            matrixB.printMatrix();
            Console.WriteLine("**************");
            matrixC.printMatrix();
            Console.WriteLine("==============");
            var watch = System.Diagnostics.Stopwatch.StartNew();
            MyMatrix<double> matrixTemp = matrixB * matrixC;
            matrixTemp = matrixA * matrixTemp;
            watch.Stop();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            matrixTemp.printMatrix();
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performThirdOperationOnMyFraction(MyMatrix<Fraction> matrixA, MyMatrix<Fraction> matrixB, MyMatrix<Fraction> matrixC, TextWriter timeWriter)
        { 
            matrixA.printMatrix();
            Console.WriteLine("*************");
            matrixB.printMatrix();
            Console.WriteLine("**************");
            matrixC.printMatrix();
            Console.WriteLine("==============");
            var watch = System.Diagnostics.Stopwatch.StartNew();
            MyMatrix<Fraction> matrixTemp = matrixB * matrixC;
            matrixTemp = matrixA * matrixTemp;
            watch.Stop();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            matrixTemp.printMatrix();
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        //----------------EXERCISE 2----------------------
        private static void performGaussianpivotingOnFloat(MyMatrix<float> matrix, TextWriter timeWriter)
        {
            matrix.printMatrix();
            var watch = System.Diagnostics.Stopwatch.StartNew();
            matrix.gaussianEliminationWithoutPivoting();
            watch.Stop();
            matrix.printVectorX();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performGaussianpivotingOnDouble(MyMatrix<double> matrix, TextWriter timeWriter)
        {
            matrix.printMatrix();
            var watch = System.Diagnostics.Stopwatch.StartNew();
            matrix.gaussianEliminationWithoutPivoting();
            watch.Stop();
            matrix.printVectorX();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performGaussianpivotingOnFraction(MyMatrix<Fraction> matrix, TextWriter timeWriter)
        {
            matrix.printMatrix();
            var watch = System.Diagnostics.Stopwatch.StartNew();
            matrix.gaussianEliminationWithoutPivoting();
            watch.Stop();
            matrix.printVectorX();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performGaussianPartialpivotingOnFloat(MyMatrix<float> matrix, TextWriter timeWriter)
        {
            matrix.printMatrix();
            var watch = System.Diagnostics.Stopwatch.StartNew();
            matrix.gaussianEliminationPartialPivoting();               
            watch.Stop();
            matrix.printVectorX();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performGaussianPartialpivotingOnDouble(MyMatrix<double> matrix, TextWriter timeWriter)
        {
            matrix.printMatrix();
            var watch = System.Diagnostics.Stopwatch.StartNew();
            matrix.gaussianEliminationPartialPivoting();
            watch.Stop();
            matrix.printVectorX();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performGaussianPartialpivotingOnFraction(MyMatrix<Fraction> matrix, TextWriter timeWriter)
        {
            matrix.printMatrix();
            var watch = System.Diagnostics.Stopwatch.StartNew();
            matrix.gaussianEliminationCompletePivoting();
            watch.Stop();
            matrix.printVectorX();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performGaussianFullpivotingOnFloat(MyMatrix<float> matrix, TextWriter timeWriter)
        {
            matrix.printMatrix();
            var watch = System.Diagnostics.Stopwatch.StartNew();
            matrix.gaussianEliminationCompletePivoting();
            watch.Stop();
            matrix.printVectorX();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performGaussianFullpivotingOnDouble(MyMatrix<double> matrix, TextWriter timeWriter)
        {
            matrix.printMatrix();
            var watch = System.Diagnostics.Stopwatch.StartNew();
            matrix.gaussianEliminationCompletePivoting();
            watch.Stop();
            matrix.printVectorX();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }

        private static void performGaussianFullpivotingOnFraction(MyMatrix<Fraction> matrix, TextWriter timeWriter)
        { 
            matrix.printMatrix();
            var watch = System.Diagnostics.Stopwatch.StartNew();
            matrix.gaussianEliminationCompletePivoting();
            watch.Stop();
            matrix.printVectorX();
            double elapsedMs = watch.Elapsed.TotalMilliseconds;
            Console.WriteLine(elapsedMs);
            timeWriter.Write(elapsedMs);
            timeWriter.Write(";");
        }
    }
}
